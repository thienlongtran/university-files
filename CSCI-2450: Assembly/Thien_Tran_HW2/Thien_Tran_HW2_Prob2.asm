;Assembly Homework 2 - Calculates Formula Below
;varA = (varA + varB) - (-varC + varD++)

.386
.model flat,stdcall
.stack 4096
ExitProcess proto, dwExitCode:dword

.data
;Change Values of Variables Here
varA DWORD 5
varB DWORD 5
varC DWORD 5
varD DWORD 5

firstPartHolder DWORD ?		;Holds (varA + varB)
secondPartHolder DWORD ?		;Holds (-varC + varD++)

.code
main PROC
	;(varA + varB)
	mov eax, varA
	add eax, varB
	mov firstPartHolder, eax

	;(-varC + varD++)
	neg varC
	inc varD
	mov eax, varC
	add eax, varD
	mov secondPartHolder, eax

	;Calculate firstPart - secondPart (saves result in eax and varA)
	mov eax, firstPartHolder
	sub eax, secondPartHolder
	mov varA, eax		;the result of (5 + 5) - (-5 + 5++) should be 9, and EAX shows that that's correct!

	main endp
end main