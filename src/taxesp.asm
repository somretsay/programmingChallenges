section .data
    job_prompt db "Enter the number of jobs: ", 0
    income_prompt db "Enter the dollar amount made for each job (enter -1 to finish): ", 0
    total_income_msg db "Total income: $", 0
    fed_tax_msg db "Federal tax (18.5%): $", 0
    state_tax_msg db "State tax (8.75%): $", 0
    final_amount_msg db "Final amount after taxes: $", 0
    newline db 0xA, 0

section .bss
    income resd 10
    total_income resd 1
    input resd 1
    fed_tax_amount resd 1
    state_tax_amount resd 1

section .text
    global _start

_start:
    ; Prompt user for the number of jobs
    mov eax, 4
    mov ebx, 1
    mov ecx, job_prompt
    mov edx, 28
    int 0x80

    ; Read user input for number of jobs
    call read_int
    mov edi, eax     ; Store the number of jobs in edi

    ; Initialize total income to 0
    xor eax, eax
    mov [total_income], eax

read_incomes_loop:
    ; Prompt user for income for each job
    mov eax, 4
    mov ebx, 1
    mov ecx, income_prompt
    mov edx, 62
    int 0x80

    ; Read user input for income
    call read_int
    cmp eax, 0          ; Check if input is negative
    jl read_incomes_loop  ; If negative, prompt again
    add [total_income], eax

    ; Check if input is -1 to finish
    cmp eax, -1
    je calculate_taxes_and_exit

    ; Repeat for next job
    jmp read_incomes_loop

calculate_taxes_and_exit:
    ; Calculate federal tax (18.5%)
    mov eax, [total_income]
    imul eax, 185
    mov ebx, 1000
    xor edx, edx
    div ebx
    mov [fed_tax_amount], eax

    ; Calculate state tax (8.75%)
    mov eax, [total_income]
    imul eax, 875
    mov ebx, 10000
    xor edx, edx
    div ebx
    mov [state_tax_amount], eax

    ; Print total income
    mov eax, 4
    mov ebx, 1
    mov ecx, total_income_msg
    mov edx, 15
    int 0x80
    mov eax, [total_income]
    call print_int
    call print_newline

    ; Print federal tax amount
    mov eax, 4
    mov ebx, 1
    mov ecx, fed_tax_msg
    mov edx, 21
    int 0x80
    mov eax, [fed_tax_amount]
    call print_int
    call print_newline

    ; Print state tax amount
    mov eax, 4
    mov ebx, 1
    mov ecx, state_tax_msg
    mov edx, 22
    int 0x80
    mov eax, [state_tax_amount]
    call print_int
    call print_newline

    ; Calculate final amount after taxes
    mov eax, [total_income]
    sub eax, [fed_tax_amount]
    sub eax, [state_tax_amount]

    ; Print final amount after taxes
    mov eax, 4
    mov ebx, 1
    mov ecx, final_amount_msg
    mov edx, 25
    int 0x80
    mov ebx, eax
    call print_int
    call print_newline

    ; Exit program
    mov eax, 1
    xor ebx, ebx
    int 0x80

read_int:
    xor eax, eax
    mov ebx, 0
    mov ecx, input
    mov edx, 21
    int 0x80
    call atoi
    ret

print_int:
    xor edx, edx
    mov ecx, 10
    div ecx
    test edx, edx
    jz .nozero
    call print_int
.nozero:
    add dl, '0'
    mov eax, 4
    mov ebx, 1
    int 0x80
    ret

print_newline:
    mov eax, 4
    mov ebx, 1
    mov ecx, newline
    mov edx, 1
    int 0x80
    ret

atoi:
    xor eax, eax
.loop:
    movzx edx, byte [ecx]
    cmp dl, 0
    je .done
    sub edx, '0'
    imul eax, eax, 10
    add eax, edx
    inc ecx
    jmp .loop
.done:
    ret
