INCLUDE Irvine32.inc

.data
info BYTE "This program calculates the GCD of two numbers.",0
promptInputOne BYTE "Enter the first number: ",0
promptInputTwo BYTE "Enter the second number: ",0
inputOne DWORD ?
inputTwo DWORD ?
foundGCD BYTE "The GCD of the two numbers is: ",0
currentGCD DWORD ?

.code
main PROC

	;Give info to the user about function of program
	mov edx, OFFSET info
	call WriteString
	call CrlF
	
	;Move first input to inputOne
	mov edx, OFFSET promptInputOne
	call WriteString
	call ReadInt
	mov inputOne, eax
	
	;Move second input to inputTwo
	mov edx, OFFSET promptInputTwo
	call WriteString
	call ReadInt
	mov inputTwo, eax
	call CrlF


	;Saves either inputOne or inputTwo into ECX - whichever is smaller
	;Important because program calculates GCD starting with smaller number
	;------------------------------------;
	cmp inputOne, eax
	jg inputOneIsLarger

	cmp inputTwo, eax
	jg inputTwoIsLarger

	inputOneIsLarger:
		mov ecx, inputTwo
		jmp exitConditional
	inputTwoIsLarger:
		mov ecx, inputOne
		jmp exitConditional
	exitConditional:
		mov currentGCD, ecx
	;------------------------------------;


	LoopGCD:
		;Sees if inputOne is easily divisible by the ECX
		mov edx, 0
		mov eax, inputOne
		div ecx
		cmp edx, 0
		je GCDinputTwo	 ;inputOne is divisible evenly
		jmp continueLoop	;inputOne is NOT divisible evenly - check the next num
		
		;If inputOne IS divisible evenly, then check if inputTwo is divisible by the same ECX
		GCDinputTwo:
			mov eax, inputTwo
			div ecx
			cmp edx, 0
			je GCDfound		;If inputTwo is evenly divisible by same ECX - then this is the GCD
			jmp continueLoop

		
		GCDfound:
			;When GCD found, the GCD is stroed into ECX
			mov eax, ecx	;Store GCD into EAX for printing
			jmp endLoop
		
		;GCD is not current number
		;Keep decrementing until GCD found
		continueLoop:
			dec currentGCD
			loop loopGCD

		endLoop:
		mov edx, OFFSET foundGCD
		call WriteString
		call WriteInt
		call CrlF
		call WaitMsg
main ENDP
END main