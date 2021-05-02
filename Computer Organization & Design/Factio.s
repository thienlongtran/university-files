        .data
	initString: .asciiz "This program prints the factorial of a number.\n"
	promptUser:   .asciiz "Enter a POSITIVE INTEGER between (inclusive) 0-12: "
	resultString: .asciiz "Result of factorial: "
	errorNumberNegative: .asciiz "ERROR: negative numbers can not be used.\n"
	errorNumberTooBig: .asciiz "ERROR: numbers above 12 can not be used.\n"

        .text
        .globl main
main:
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
	add $t0, $a0, $zero
	addi $t1, $zero, 1
	j factorialLoop

factorialLoop:
	#t0 = Current Iteration Index
	#t1 = Current Result of Factorial
	beq $t0, $zero, ExitFromFactorial
	mul $t1, $t1, $t0
	addi $t0, $t0, -1
	j factorialLoop
	
ExitFromFactorial:
	li $v0, 4
	la $a0, resultString
	syscall
	li $v0, 1
	add $a0, $zero, $t1
	syscall
	jr $ra

printResult:
	li $v0, 1
	syscall
        
        jr $ra

numTooBig:
	li $v0, 4
	la $a0, errorNumberTooBig
	syscall
	jr $ra

negativeNumber:
	li $v0, 4
	la $a0, errorNumberNegative
	syscall
	jr $ra

numIsZero:
	li $v0, 4
	la $a0, resultString
	syscall
	li $v0, 1
	addi $a0, $zero, 1
	syscall
	jr $ra