; Program to calculate total income and taxes

section .data
    prompt_job: db "Enter the income for job ", 0
    prompt_total: db "Total income for the year: $", 0
    prompt_federal_tax: db "Federal tax (18.5%): $", 0
    prompt_state_tax: db "State tax (8.75%): $", 0
    newline: db 0xA, 0xD

section .bss
    income: resq 10
    total_income: resq 1
    federal_tax: resq 1
    state_tax: resq 1
    temp: resq 1

section .text
    global _start

_start:
    ; Initialize total_income, federal_tax, state_tax to 0
    mov qword [total_income], 0
    mov qword [federal_tax], 0
    mov qword [state_tax], 0
    
    ; Loop to get income for each job
    mov rdi, prompt_job
    call print_string
    mov rcx, 1  ; job number
input_loop:
    ; Prompt user for income
    mov rdi, rcx
    call print_integer
    mov rdi, prompt_job
    call print_string
    
    ; Read income from user
    mov rdi, income
    call read_integer
    
    ; Check for negative income
    mov rdi, income
    call check_negative
    cmp rax, 1
    je input_loop
    
    ; Add income to total_income
    mov rax, [income]
    add qword [total_income], rax
    
    ; Prompt user for more income
    mov rdi, newline
    call print_string
    mov rdi, "Enter income for another job? (1 for yes, 0 for no): "
    call print_string
    call read_integer
    cmp rax, 1
    je input_loop
    
    ; Calculate federal tax (18.5%)
    mov rax, [total_income]
    mov rdi, 1850  ; 18.5% * 100
    mov rsi, 100
    call divide
    mov [federal_tax], rax
    
    ; Calculate state tax (8.75%)
    mov rax, [total_income]
    mov rdi, 875  ; 8.75% * 100
    mov rsi, 100
    call divide
    mov [state_tax], rax
    
    ; Print total income and taxes
    mov rdi, prompt_total
    call print_string
    mov rdi, [total_income]
    call print_integer
    mov rdi, newline
    call print_string
    
    mov rdi, prompt_federal_tax
    call print_string
    mov rdi, [federal_tax]
    call print_integer
    mov rdi, newline
    call print_string
    
    mov rdi, prompt_state_tax
    call print_string
    mov rdi, [state_tax]
    call print_integer
    mov rdi, newline
    call print_string
    
    ; Exit the program
    mov rax, 60  ; syscall number for exit
    xor rdi, rdi  ; exit status 0
    syscall

; Function to print a string
print_string:
    mov rax, 0x1  ; syscall number for write
    mov rsi, rdi  ; address of string to print
    xor rdx, rdx  ; length of string (null terminated)
    mov rdx, 0xFF
    syscall
    ret

; Function to read an integer from user
read_integer:
    mov rax, 0x0  ; syscall number for read
    mov rdi, 0x0  ; file descriptor for stdin
    mov rsi, rdi  ; buffer to store input
    mov rdx, 0xFF  ; buffer size
    syscall
    call atoi
    ret

; Function to convert string to integer
atoi:
    xor rax, rax  ; clear rax
    mov rcx, rsi  ; rcx points to the string
    mov rdx, 10  ; base 10
atoi_loop:
    movzx rbx, byte [rcx]  ; load current character
    test rbx, rbx  ; check for null terminator
    jz atoi_done
    cmp rbx, 0x30  ; check if character is a digit
    jb atoi_done
    cmp rbx, 0x39
    ja atoi_done
    sub rbx, 0x30  ; convert ASCII to integer
    imul rax,
