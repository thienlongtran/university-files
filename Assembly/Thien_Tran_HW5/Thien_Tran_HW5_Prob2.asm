INCLUDE Irvine32.inc

.data
	productResult DWORD 0
	info BYTE "This program multiplies two numbers together using the multiplication distributive property.",0
	promptInputOne BYTE "Enter the multiplier (from 0-127): ",0
	promptInputTwo BYTE "Enter the multiplicand: ",0
	showMultiplierTooBig BYTE "The multiplier is too big. Try again.",0
	resultIs BYTE "The product is: ",0
	possibleMultipliers DWORD 1, 2, 4, 8, 16, 32, 64
	multiplier DWORD ?
	multiplicand DWORD ?
	distributiveSumArray DWORD 512 dup(0)

.code
main PROC

	;Display Program Info
	mov edx, OFFSET info
	call WriteString
	call CrlF

	;Prompt user for inputs
	;-----------------------------------;
	;Move first input to inputOne
	redoMultiplier:
	mov edx, OFFSET promptInputOne
	call WriteString
	call ReadInt
	mov multiplier, eax

	cmp eax, 127
	jg multiplierToBig
	jmp secondInput

	;Label to jump to if multiplier > 127
	multiplierToBig: 
		mov edx, OFFSET showMultiplierTooBig
		call WriteString
		call CrlF
		jmp redoMultiplier
	
	;Move second input to inputTwo
	secondInput:	;Label to jump to if multiplier is good
	mov edx, OFFSET promptInputTwo
	call WriteString
	call ReadInt
	mov multiplicand, eax
	call CrlF
	;-----------------------------------;


	;Move EBX to the offset of possibleMultipliers starting at the back
	;-----------------------------------;
	mov eax, LENGTHOF possibleMultipliers
	sub eax, 1
	mov ebx, TYPE possibleMultipliers
	mul ebx
	mov ecx, LENGTHOF possibleMultipliers
	mov ebx, OFFSET possibleMultipliers
	add ebx, eax	;Move offset to the end of array
	;-----------------------------------;


	;Check if multiplier or multiplicand is zero
	cmp multiplier, 0
	jz isZero
	cmp multiplicand, 0
	jz isZero
	
	;Finds the distributive sum of the multiplier
	;Save distributive sums as list in distributiveSumArray
	mov edi, 0	;Store the length of distributive sum array
	mov ebp, 0	;Store current index of array of distributiveSums
	mov esi, multiplier

	findDistributiveSumLoop:
		mov eax, [ebx]
		cmp eax, esi
		jg tooLarge
		jmp validDistributive
		
		tooLarge:
			jmp continueLoop
		
		validDistributive:
			inc edi		;Increase size of array by one
			mov eax, [ebx]
			mov distributiveSumArray[ebp], eax
			add ebp, TYPE distributiveSumArray	;Moves to next index in array
			sub esi, eax
			mul multiplicand
			add productResult, eax
			jmp continueLoop
		
		continueLoop:
			sub ebx, TYPE possibleMultipliers	;Goes to the previous value in array
			loop findDistributiveSumLoop
		jmp foundProduct
	
	
	;Once the distributive sums are in array
	arrayCompleted:


	;If either multiplier of multiplicand is zero, then product is zero
	isZero:
		jmp foundProduct

	foundProduct:
	;Product saved in productResult
	;Print out the results
	mov edx, OFFSET resultIs
	call WriteString
	mov eax, productResult
	call WriteInt
	call CrlF
	call WaitMsg
	
main ENDP
END main