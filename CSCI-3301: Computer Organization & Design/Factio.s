    .data
	initString: .asciiz "This program prints the factorial of a number.\n"
	promptUser:   .asciiz "Enter a POSITIVE INTEGER between (inclusive) 0-12: "
	resultString: .asciiz "Result of factorial: "
	errorNumberNegative: .asciiz "ERROR: negative numbers can not be used.\n"
	errorNumberTooBig: .asciiz "ERROR: numbers above 12 can not be used.\n"

    .text
    .globl main
main:
	#Print Info about Program and Prompts User for Integer
	li $v0, 4
	la $a0, initString
	syscall
    la $a0, promptUser
    syscall

	#Read Input and Save to $a0
	li $v0, 5
	syscall
	add $a0, $v0, $zero

	#Check if Number is Too Big
	addi $t0, $zero, 12
	bgt $a0, $t0, numTooBig

	#Check if Number is Negative
	addi $t0, $zero, 0
	blt $a0, $t0, negativeNumber

	#Check Special Case When Num = 0
	addi $t0, $zero, 0
	beq $a0, $t0, numIsZero
	
	#Get Factorial When Previous Cases False
	add $t0, $a0, $zero #Move Inpout to $t0 (for recursion calls)
	add $t2, $a0, $zero #Move Inpout to $t2 (for recursion jump backs)
	addi $s0, $zero, 1
	j factorialLoop

#Call Recursion Until Num = 1
factorialLoop:
	#t0 = Current Iteration Index
	beq $t0, $zero, factorialUnloop #Stop recursion calls and start 'hopping' back out when num = 1
	addi $sp, $sp, -4 #Allocate stack space for current Iteration Index
	sw $t0, ($sp) #Save current Iteration Index to stack
	addi $t0, $t0, -1 #Decrement iteration
	j factorialLoop

#'Hop Out' of the Recursion call stack
factorialUnloop:
	#s0 = Current Result of Factorial (starts at 1)
	beq $t2, $zero, Exit #Exit program when iteration index = 0
	addi $t2, $t2, -1 #Decrement iteration idnex
	lw $t5, ($sp) #Load recursive call items from stack to $t5
	addi $sp, $sp, 4 #Move down stack when item retrieved
	mul $s0, $s0, $t5 #Multiply current result of factorial by current iteration
	j factorialUnloop

numTooBig:
	#Print Too Big Error Message and Exit Program
	li $v0, 4
	la $a0, errorNumberTooBig
	syscall
	li $v0, 10
    syscall

negativeNumber:
	#Print Negative Number Error Message and Exit Program
	li $v0, 4
	la $a0, errorNumberNegative
	syscall
	li $v0, 10
    syscall

numIsZero:
	#Set Result of Factorial to 0 and jump to Exit
	li $v0, 4
	la $a0, resultString
	syscall
	addi $s0, $zero, 1
	j Exit

Exit:
	#Print Number
	li $v0, 1
	add $a0, $zero, $s0
	syscall

	#Terminate Program
    li $v0, 10
    syscall