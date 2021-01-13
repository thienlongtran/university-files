INCLUDE Irvine32.inc

.data
	promptForString BYTE "Enter the string you want to encrypt: ",0
	promptForKey BYTE "Enter the key you want to encrypt your string with: ",0
	promptEncryptedString BYTE "Encrypted String: ",0
	promptDecryptedString BYTE "Decrypted String: ",0

	inputString BYTE 256 dup(0)
	key BYTE 128 dup(0)

	encryptedString BYTE 256 dup(0)
	decryptedString BYTE 256 dup(0)

	KeyLength DWORD ?

.code
main proc
	;Prompt user to enter a string and save it.
	mov edx, OFFSET promptForString
	call WriteString
	mov ecx, 50
	mov edx, OFFSET inputString
	call ReadString
	mov ecx, eax	;Moves length of inpt string to ECX

	;Prompt user to enter a key and save it.
	inc ecx
	mov edx, OFFSET promptForKey
	call WriteString
	mov edx, OFFSET key
	call ReadString
	call CrlF

	mov KeyLength, eax
	push ecx
	mov ebx, 0
	mov ebp, OFFSET inputString
	mov edx, 0



	;Encryption: encrypt each letter of the string one-by-one by XOR logic
	EncryptionLoop:
		mov ah, [ebp]
		XOR ah, key[ebx]
		mov encryptedString[edx], ah

		;Note to Self: These two commands below are equivalent to: add register, TYPEOF theStrings
		inc ebp		;Goes to next letter of the input
		inc ebx		;Goes to next letter of key
		inc edx		;Goes to next position of the encryptedString storage

		;If there is no more letters in "key", reset to position 0
		cmp ebx, KeyLength
		je resetKeyIndex
		jmp exitLoop

		resetKeyIndex:
			mov ebx, 0

		exitLoop:

		loop EncryptionLoop
	


	mov edx, OFFSET promptEncryptedString
	call WriteString
	mov edx, OFFSET encryptedString
	call WriteString
	call CrlF
	;Reset registers
	pop ecx
	mov ebx, 0
	mov ebp, OFFSET encryptedString
	mov edx, 0


	DecryptionLoop:
		mov ah, [ebp]
		XOR ah, key[ebx]
		mov decryptedString[edx], ah

		;Note to Self: These two commands below are equivalent to: add register, TYPEOF theStrings
		inc ebp		;Goes to next letter of the input
		inc ebx		;Goes to next letter of key
		inc edx		;Goes to next position of the encryptedString storage


		;If there is no more letters in "key", reset to position 0
		cmp ebx, KeyLength
		je decryptResetKeyIndex
		jmp decryptExitLoop

		decryptResetKeyIndex:
			mov ebx, 0

		decryptExitLoop:

		loop DecryptionLoop


	;;Makes sure that the Decryption works
	mov edx, OFFSET promptDecryptedString
	call WriteString
	mov edx, OFFSET decryptedString
	call WriteString
	call CrlF
	call WaitMsg
main endp
end main