;Somret Say
;May 1st 2024


section .data
    prompt_msg db "Enter your income for job ", 0
    neg_msg db "Income cannot be less than 0", 0
    total_income_msg db "Total income before taxes: $", 0
    fed_tax_msg db "Income after federal taxes: $", 0
    state_tax_msg db "Income after state taxes: $", 0
    newline db 0xA, 0

section .bss
    income resd 10
    sum resd 1
    fed resd 1
    state resd 1

section .text
    global _start

_start:
    mov esi, income  ; pointer to income array
    mov ecx, 1       ; job counter

input_loop:
    ; prompt the user for income
    mov eax, 4
    mov ebx, 1
    mov ecx, prompt_msg
    mov edx, 28
    int 0x80
    
    ; read user input for income
    mov eax, 3
    mov ebx, 0
    mov ecx, esi
    mov edx, 10
    int 0x80
    
    ; check if income is -1 to break
    cmp dword [esi], -1
    je calculate_taxes
    ; check if income is negative
    cmp dword [esi], 0
    jl negative_Income
    ; Add income to sum
    add dword [sum], dword [esi]
    add esi, 4  ; move to next income slot
    inc ecx     ; increment job number
    jmp input_loop

negative_Income:
    ; error message
    mov eax, 4
    mov ebx, 1
    mov ecx, neg_msg
    mov edx, 28
    int 0x80
    dec ecx  ; restore counter for job number
    jmp input_loop

calculate_taxes:
    ; calculate federal tax (18.5%)
    mov eax, dword [sum]
    mov ebx, 185
    imul ebx
    mov ecx, 1000
    xor edx, edx
    div ecx
    mov dword [fed], eax

    ; calculate state tax (8.75%)
    mov eax, dword [sum]
    mov ebx, 875
    imul ebx
    mov ecx, 10000
    xor edx, edx
    div ecx
    mov dword [state], eax

    ; print total income before taxes
    mov eax, 4
    mov ebx, 1
    mov ecx, total_income_msg
    mov edx, 30
    int 0x80
    mov eax, dword [sum]
    call print_int
    call print_newline

    ; print income after federal taxes
    mov eax, 4
    mov ebx, 1
    mov ecx, fed_tax_msg
    mov edx, 26
    int 0x80
    mov eax, dword [fed]
    call print_int
    call print_newline

    ; pint income after state taxes
    mov eax, 4
    mov ebx, 1
    mov ecx, state_tax_msg
    mov edx, 27
    int 0x80
    mov eax, dword [state]
    call print_int
    call print_newline

    ; exit 
    mov eax, 1
    xor ebx, ebx
    int 0x80

print_newline:
    mov eax, 4
    mov ebx, 1
    mov ecx, newline
    mov edx, 1
    int 0x80
    ret

print_int:
    push eax
    mov eax, esp
    call print_int_internal
    pop eax
    ret

print_int_internal:
    cmp eax, 0
    jge print_int_positive
    push eax
    mov eax, '-'
    push eax
    mov eax, esp
    call print_char
    pop eax
    pop eax
    neg eax
    print_int_positive:
    xor edx, edx
    mov ebx, 10
    div ebx
    test eax, eax
    jz .end
    push eax
    call print_int_internal
    pop eax
.end:
    add dl, '0'
    push edx
    mov eax, esp
    call print_char
    pop edx
    ret

print_char:
    mov eax, 4
    mov ebx, 1
    mov ecx, esp
    mov edx, 1
    int 0x80
    ret

