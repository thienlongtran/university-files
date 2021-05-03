    .data 
    initString: .asciiz "This program sorts an array of integers.\n"
    promptUserArraySize:   .asciiz "Enter the size of the array: "
    promptUserArrayItems:   .asciiz "Enter the integers in the array: \n"
    emptyArraySize: .asciiz "The array is empty.\n"
    preresultString: .asciiz "You have entered: "
	resultString: .asciiz "Here is the sorted list in ascending order: "
    integerArray: .word 24 

    .text
    .globl main 
main:
    #Print Info about Program and Prompts User to Enter Array Size
	li $v0, 4
	la $a0, initString
	syscall
    la $a0, promptUserArraySize
    syscall

    #Read Input of Array Size and Save to $a0
	li $v0, 5
	syscall
	add $a0, $v0, $zero #Save Array Size to $a0
    add $s2, $zero, $a0 #Save Array Size to $s2
    sll $s1, $s2, 2 #Save Memory Offset of Array to $s1

    #Exit if Array Length = 0
    beq $s2, $zero, emptyArray

    #Prompt Users for Items
    li $v0, 4
	la $a0, promptUserArrayItems
    syscall

    #Initialize Array
    la $s0, integerArray #Save Memory Location of intArray to $s0
    add $t0, $zero, $s2 #Set Amount of Iterations to $t0
    jal createArray

    #Print Unsorted Array
    li $v0, 4
	la $a0, preresultString
    syscall
    la $s0, integerArray
    add $t0, $zero, $s2
    jal printArray

    #Sort Array
    add $t1, $zero, $s2 #Set Amount of Iterations of Outer Loop to $t1
    jal sortArray

    #SAVE FIRST 6 ARRAY ITEMS TO t1-t6
    #FOR DEBUGGING PURPOSES
    la $s0, integerArray #Save Memory Location of intArray to $s0
    lw $t1, 0($s0)
    lw $t2, 4($s0)
    lw $t3, 8($s0)
    lw $t4, 12($s0)
    lw $t5, 16($s0)
    lw $t6, 20($s0)

    #Print Sorted Array
    li $v0, 4
	la $a0, resultString
    syscall
    la $s0, integerArray
    add $t0, $zero, $s2
    jal printArray

    j Exit

createArray:
    #Initialize Array of User-defined Size with User's Inputs
    li $v0, 5 #Read Input
    syscall #Read Input
    add $t2, $zero, $v0 #Set $t2 to User's Input
    sw $t2, ($s0) #Save Input to Current List at Index
    addi $s0, $s0, 4 #Increment Stack for Next Word
    addi $t0, $t0, -1 #Decrement Iteration Index
    bne $t0, $zero, createArray
    sub $s0, $s0, $s1
    jr $ra

sortArray:
    #Bubble Sort Outer Loop
    la $s0, integerArray #Save Memory Location of intArray to $s0
    addi $s0, $s0, -4 #Decrement $s0 by one byte for Inner Loop Init
    sw $ra, ($sp) #Save Return to Main PC to Stack
    add $t0, $zero, $t1 #Set Amount of Iterations of Nested Loop to $t0
    jal swapLoop #Inner Loop
    addi $t1, $t1, -1
    lw $ra, ($sp) #Restore Main PC to $ra
    bne $t1, $zero, sortArray
    jr $ra #Jump back to Main when Sorting Done

swapLoop:
    #Bubble Sort Nested Loop
    addi $t0, $t0, -1 #Decrement Iteration Amount
    addi $s0, $s0, 4 #Update $s0 to next array index
    
    #Exit Loop When All Array Items Have Been 'Looked At'
    beq $t0, $zero, exitLoop

    #Swap if ($s0) > 4($s0) since it would not be in order
    lw $t4, ($s0) #Load $t4 with Array[Index]
    lw $t5, 4($s0) #Load $t5 with Array[Index + 1]
    ble $t4, $t5, swapLoop
    sw $t5, ($s0)
    sw $t4, 4($s0)


    j swapLoop

exitLoop:
    jr $ra

printArray:
    #Print array whose starting memory is in $s0 and size is in $t0

    #Print Item
    li $v0, 1
    lw $a0, ($s0)
	syscall

    #Print Space
    li $v0, 11
    addi $a0, $zero, 32
	syscall

    addi $t0, $t0, -1 #Decrement Iterations
    addi $s0, $s0, 4 #Move to next array item
    bne $t0, $zero, printArray #Repeat if Iteration =/= 0

    #Print New Line and Return
    addi $a0, $0, 10
    addi $v0, $0, 11
    syscall
    jr $ra

emptyArray:
    li $v0, 4
	la $a0, emptyArraySize
    syscall
    j Exit

Exit:
    li $v0, 10
    syscall