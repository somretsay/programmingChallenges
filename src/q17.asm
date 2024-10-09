   section .data
    X       dd 0         ; Define variable X as a 32-bit integer initialized to 0

section .text
    global _start       ; Entry point for the program

_start:
    ; Load values into registers
    mov eax, 5          ; Sample value for eax
    mov ebx, 10         ; Sample value for ebx
    mov ecx, 7          ; Sample value for ecx
    mov edx, 8          ; Sample value for edx
    cmp ebx, ecx        ; Compare ebx and ecx
    jle check1      ; Jump if ebx is less than or equal to ecx
    cmp ebx, edx        ; Compare ebx and edx
    jle set2          ; Jump if ebx is less than or equal to edx
    jmp set1          ; Otherwise, set X to 1

check1:
    cmp edx, eax        ; Compare edx and eax
    jle set2          ; Jump if edx is less than or equal to eax
    jmp set1      ; Otherwise, set X to 1

set2:
    mov dword [X], 2    ; Set X to 2
    jmp end_program     ; Jump to end of the program

set1:
    mov dword [X], 1    ; Set X to 1

end_program:
    ; End of the program
    ; Exit the program
    mov eax, 1          ; syscall number for 'exit'
    xor ebx, ebx        ; Exit code 0
    int 0x80            ; Call kernel
