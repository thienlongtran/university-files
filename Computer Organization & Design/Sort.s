    .data 
    initString: .asciiz "This program sorts an array of integers.\n"
    promptUserArraySize:   .asciiz "Enter the size of the array: "
    promptUserArrayItems:   .asciiz "Enter the integers in the array: \n"
	resultString: .asciiz "Sorted Array: "
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

    #Prompt Users for Items
    li $v0, 4
	la $a0, promptUserArrayItems
    syscall

    #Initialize Array
    la $s0, integerArray #Save Memory Location of intArray to $s0
    add $t0, $zero, $s2 #Set Amount of Iterations to $t0
    jal createArray

    #Sort Array
    la $s0, integerArray #Save Memory Location of intArray to $s0
    add $t0, $zero, $s2 #Set Amount of Iterations to $t0
    jal sortArray

    #DEBUGGING PURPOSES
    #WORKING
    la $s0, integerArray #Save Memory Location of intArray to $s0
    lw $t1, 0($s0)
    lw $t2, 4($s0)
    lw $t3, 8($s0)
    lw $t4, 12($s0)
    lw $t5, 16($s0)

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
    #Bubble Sort
    sw $ra, ($sp) #Save Return to Main PC to Stack
    jal swapLoop
    lw $ra, ($sp)
    jr $ra

swapLoop:
    addi $t0, $t0, -1
    bne $t0, $zero, swapLoop
    jr $ra

Exit:
    li $v0, 4
	la $a0, promptUserArrayItems #Prompt Users for Items
    syscall
    li $v0, 10
    syscall