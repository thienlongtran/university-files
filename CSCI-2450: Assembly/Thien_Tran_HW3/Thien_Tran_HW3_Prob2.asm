INCLUDE Irvine32.inc

.data
;Prompts
promptString BYTE "Enter a string to check for palindrome: ",0
promptEnd BYTE "Press enter to end program.",0

;Empty - will store the strings
enteredString BYTE 50 dup(0)
reversedString BYTE 50 dup(0)

;Results of palindrome test
resultIsPalindrome BYTE "Palindrome",0
resultNotPalindrome BYTE "NOT palindrome.",0

.code
main proc
	mov edx, OFFSET promptString	;moves EDX to promptString
	call WriteString	;prints out thing in EDX (promptString)
	mov ecx, 50		;Max length of string
	mov edx, offSet enteredString
	call ReadString		;Prompt user to enter string - string length store in EAX

;-------------------------------------------------------------------------------;
	;Same Procedure From Part 1 - Assembly HW
	mov ecx, eax	;Move string length into ECX
	mov esi, 0
	push ecx


	;Saves strings in order on the stack
	LoopSaveStrings:
		movzx eax, enteredString[esi]
		push eax
		inc esi
		loop LoopSaveStrings

	mov ecx, esi
	mov edx, 0

	;Copies each letter starting from the top of the stack into reversedString
	LoopLoadStrings:
		pop eax
		mov reversedString[edx], al
		inc edx
		dec esi
		loop LoopLoadStrings
;-------------------------------------------------------------------------------;

	pop ecx		;Gets size of string from earlier
	call CheckPalindrome
	call WriteString	;Writes result of Palindrome Test
	call Crlf
	call WaitMsg
	


main endp

CheckPalindrome proc
	;Compares each letter one-by-one of the reversed string and the original string
	;ECX Value must be set to the length of the string beforehand
	;Checks for palindromeness (I know that's not an actual word)
	;Sets EDX value to offset of the result
	mov edx, 0
	palindromeCheckLoop:
		mov al, enteredString[edx]
		mov ah, reversedString[edx]
		inc edx
		cmp ah,al
		jne notPalinDrome
		loop palindromeCheckLoop

		jmp isPalindrome

	notPalinDrome:
		mov edx, OFFSET resultNotPalindrome
		ret

	isPalinDrome:
		mov edx, OFFSET resultIsPalindrome
		ret
CheckPalindrome endp
end main