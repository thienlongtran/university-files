    .data 
    initString: .asciiz "This program sorts an array of integers.\n"
    promptUserArraySize:   .asciiz "Enter the size of the array: "
    promptUserArrayItems:   .asciiz "Enter the integers in the array: \n"
	resultString: .asciiz "Sorted Array: "
    integerArray: .word 12

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
	add $a0, $v0, $zero

    #Create an Empty Array
    sll $s0, $a0, $zero #Store Stack Pointer Offset at $s0
    sub $sp, $sp, $s0

    #Initialize Array
    add $t0, $zero, $a0 #Save Array Size to $t0
    li $v0, 4
	la $a0, promptUserArrayItems #Prompt Users for Items
    la $s1, integerArray #Save address of integerArray to $s1
	syscall
    jal createArray

    li $v0, 4
	la $a0, promptUserArrayItems #Prompt Users for Items
    syscall

createArray:
    #Initialize Array of User-defined Size with User's Inputs
    li $v0, 5
    syscall
    add $t2, $zero, $v0 #Set $t2 to User's Input
    sw $t2, ($s1) #Save Input to Current List at Index
    addi $s1, $s1, 4 #Increment Stack for Next Word
    addi $t0, $t0, -1 #Decrement Iteration Index
    bne $t0, $zero, createArray
    sub $sp, $sp, $s0 #Reset $s1 Index of Array
    jr $ra