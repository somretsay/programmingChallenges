section .data
    prompt_msg db "Enter the number of jobs: ", 0
    job_amount_msg db "Enter the amount earned in job ", 0
    total_income_msg db "Total income: $", 0
    federal_tax_msg db "Federal tax (18.5%): $", 0
    state_tax_msg db "State tax (8.75%): $", 0
    final_amount_msg db "Final amount after taxes: $", 0
    newline db 10, 0
    input_buffer resd ?
    num_jobs resd ?
    job_amount resd ?
    total_income resd ?
    federal_tax resd ?
    state_tax resd ?
    final_amount resd ?

section .text
    global _start

_start:
    ; Prompt the user for the number of jobs
    mov eax, 4
    mov ebx, 1
    mov ecx, prompt_msg
    mov edx, 29
    int 0x80

    ; Read the number of jobs
    mov eax, 3
    mov ebx, 0
    mov ecx, input_buffer
    mov edx, 4
    int 0x80
    mov eax, dword [input_buffer]
    mov dword [num_jobs], eax

    ; Initialize total income to 0
    mov dword [total_income], 0

input_loop:
    ; Check if all jobs have been processed
    cmp dword [num_jobs], 0
    je calculate_taxes

    ; Prompt the user for the amount earned in the current job
    mov eax, 4
    mov ebx, 1
    mov ecx, job_amount_msg
    mov edx, 29
    int 0x80

    ; Read the amount earned in the current job
    mov eax, 3
    mov ebx, 0
    mov ecx, input_buffer
    mov edx, 4
    int 0x80
    mov eax, dword [input_buffer]
    add dword [total_income], eax

    ; Decrement the job counter
    sub dword [num_jobs], 1

    ; Continue looping
    jmp input_loop

calculate_taxes:
    ; Calculate federal tax (18.5%)
    mov eax, dword [total_income]
    mov ebx, 1000
    imul eax, 185
    idiv ebx
    mov dword [federal_tax], eax

    ; Calculate state tax (8.75%)
    mov eax, dword [total_income]
    mov ebx, 10000
    imul eax, 875
    idiv ebx
    mov dword [state_tax], eax

    ; Calculate final amount after deducting taxes
    mov eax, dword [total_income]
    sub eax, dword [federal_tax]
    sub eax, dword [state_tax]
    mov dword [final_amount], eax

    ; Print total income
    mov eax, 4
    mov ebx, 1
    mov ecx, total_income_msg
    mov edx, 14
    int 0x80
    mov eax, dword [total_income]
    call print_integer
    call print_newline

    ; Print federal tax
    mov eax, 4
    mov ebx, 1
    mov ecx, federal_tax_msg
    mov edx, 18
    int 0x80
    mov eax, dword [federal_tax]
    call print_integer
    call print_newline

    ; Print state tax
    mov eax, 4
    mov ebx, 1
    mov ecx, state_tax_msg
    mov edx, 17
    int 0x80
    mov eax, dword [state_tax]
    call print_integer
    call print_newline

    ; Print final amount after taxes
    mov eax, 4
    mov ebx, 1
    mov ecx, final_amount_msg
    mov edx, 26
    int 0x80
    mov eax, dword [final_amount]
    call print_integer
    call print_newline

    ; Exit program
    mov eax, 1
    xor ebx, ebx
    int 0x80

print_integer:
    ; Print integer in eax
    ; Implementation goes here
    ret

print_newline:
    ; Print newline character
    ; Implementation goes here
    ret
