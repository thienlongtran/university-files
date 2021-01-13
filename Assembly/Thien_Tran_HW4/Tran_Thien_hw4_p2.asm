INCLUDE Irvine32.inc

.data
	booleanCalculator BYTE "Boolean Calculator - Enter Number of Operation You Want to Perform",0
	restartNonValidCommand BYTE "That isn't a valid operation, try again.",0
	Op_1 BYTE "1: x AND y",0
	Op_2 BYTE "2: x OR y",0
	Op_3 BYTE "3: NOT x",0
	Op_4 BYTE "4: x XOR y",0

	firstInput BYTE "Enter first hexadecimal integer: ",0
	secondInput BYTE "Enter second hexidecimal integer: ",0
	onlyInput BYTE "Enter a hexidecimal integer: ",0

.code
main proc
	mov edx, OFFSET booleanCalculator
	call WriteString
	call CrlF
	
	restartProgram:
	mov edx, OFFSET Op_1
	call WriteString
	call CrlF

	mov edx, OFFSET Op_2
	call WriteString
	call CrlF

	mov edx, OFFSET Op_3
	call WriteString
	call CrlF

	mov edx, OFFSET Op_4
	call WriteString
	call CrlF

	call ReadInt	;Saves operation number in EAX
	cmp eax, 1
	je AND_op

	cmp eax, 2
	je OR_op

	cmp eax, 3
	je NOT_op

	cmp eax, 4
	je XOR_op

	mov edx, OFFSET restartNonValidCommand
	call WriteString
	call CrlF
	jmp restartProgram

	AND_op:
		mov edx, OFFSET firstInput
		call WriteString
		call ReadHex
		mov ebx, eax

		mov edx, OFFSET secondInput
		call WriteString
		call ReadHex
		AND eax, ebx
		jmp endOfProgram

	OR_op:
		mov edx, OFFSET firstInput
		call WriteString
		call ReadHex
		mov ebx, eax

		mov edx, OFFSET secondInput
		call WriteString
		call ReadHex
		OR eax, ebx
		jmp endOfProgram

	NOT_op:
		mov edx, OFFSET onlyInput
		call WriteString
		call ReadHex
		NOT eax
		jmp endOfProgram

	XOR_op:
		mov edx, OFFSET firstInput
		call WriteString
		call ReadHex
		mov ebx, eax

		mov edx, OFFSET secondInput
		call WriteString
		call ReadHex
		XOR eax, ebx
		jmp endOfProgram

	endOfProgram:
	call WriteHex
	call CrlF
	call WaitMsg
main endp
end main