INCLUDE Irvine32.inc

.data
promptString BYTE "Enter a string: ",0
displayReversed BYTE "Your reversed String: ",0
enteredString BYTE 50 dup(0)
reversedString BYTE 50 dup(0)

.code
main proc

	mov edx, OFFSET promptString	;moves EDX to promptString
	call WriteString	;prints out thing in EDX (promptString)
	mov ecx, 50		;Max length of string
	mov edx, offSet enteredString
	call ReadString		;Prompt user to enter string - string length store in EAX
	mov ecx, eax	;Move string length into ECX
	push ecx
	mov esi, 0

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

	mov edx, OFFSET displayReversed
	call WriteString
	mov edx, OFFSET reversedString
	call WriteString
	call Crlf
	call WaitMsg

main endp
end main