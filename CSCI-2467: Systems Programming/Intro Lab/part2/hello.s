	.file	"hello.i"
	.intel_syntax noprefix
	.text
	.section	.rodata
.LC0:
	.string	"Hello world."
	.text
	.globl	main
	.type	main, @function
main:
.LFB0:
	.cfi_startproc
	push	rbp
	.cfi_def_cfa_offset 16
	.cfi_offset 6, -16
	mov	rbp, rsp
	.cfi_def_cfa_register 6
	sub	rsp, 16
	mov	DWORD PTR -4[rbp], 67 #This is where the value (67) is placed for retval
	lea	rdi, .LC0[rip]
	call	puts@PLT #This is where printf is called
	mov	eax, DWORD PTR -4[rbp] #The value for retval is stored in -4[rbp] and then eventually here at EAX
	leave
	.cfi_def_cfa 7, 8
	ret #This is where the function actually returns
	.cfi_endproc
.LFE0:
	.size	main, .-main
	.ident	"GCC: (Ubuntu 7.5.0-3ubuntu1~18.04) 7.5.0"
	.section	.note.GNU-stack,"",@progbits
