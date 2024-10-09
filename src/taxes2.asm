; Include necessary libraries and define constants
.386
.MODEL FLAT, STDCALL
.DATA
prompt_msg BYTE "Enter the number of jobs: ", 0
job_amount_msg BYTE "Enter the amount earned in job ", 0
total_income_msg BYTE "Total income: $", 0
federal_tax_msg BYTE "Federal tax (18.5%): $", 0
state_tax_msg BYTE "State tax (8.75%): $", 0
final_amount_msg BYTE "Final amount after taxes: $", 0
input_buffer DWORD ?
num_jobs DWORD ?
job_amount DWORD ?
total_income DWORD ?
federal_tax DWORD ?
state_tax DWORD ?
final_amount DWORD ?
.CODE

; Entry point
START:
    ; Prompt the user for the number of jobs
    mov edx, OFFSET prompt_msg
    call WriteString
    call ReadInt
    mov num_jobs, eax

    ; Loop to input job amounts and calculate total income
    mov ecx, num_jobs       ; Set loop counter
    mov esi, 0              ; Initialize total income to 0
    mov ebx, 1              ; Initialize job counter to 1

input_loop:
    ; Prompt the user for the amount earned in the current job
    mov edx, OFFSET job_amount_msg
    call WriteString
    call ReadInt
    mov job_amount, eax

    ; Add job amount to total income
    add esi, job_amount

    ; Increment job counter
    inc ebx

    ; Check if all jobs have been processed
    cmp ebx, ecx
    jne input_loop

    ; Calculate federal tax (18.5%)
    mov eax, esi            ; Load total income
    mov edx, 185            ; 18.5% represented as an integer
    mul edx                 ; Multiply total income by 18.5%
    mov ebx, 100            ; Divide by 100
    div ebx

    ; Store federal tax
    mov federal_tax, eax

    ; Calculate state tax (8.75%)
    mov eax, esi            ; Load total income
    mov edx, 875            ; 8.75% represented as an integer
    mul edx                 ; Multiply total income by 8.75%
    mov ebx, 1000           ; Divide by 1000
    div ebx

    ; Store state tax
    mov state_tax, eax

    ; Calculate final amount after deducting taxes
    mov eax, esi            ; Load total income
    sub eax, federal_tax    ; Subtract federal tax
    sub eax, state_tax      ; Subtract state tax
    mov final_amount, eax

    ; Print total income
    mov edx, OFFSET total_income_msg
    call WriteString
    mov eax, esi
    call WriteInt
    call Crlf

    ; Print federal tax
    mov edx, OFFSET federal_tax_msg
    call WriteString
    mov eax, federal_tax
    call WriteInt
    call Crlf

    ; Print state tax
    mov edx, OFFSET state_tax_msg
    call WriteString
    mov eax, state_tax
    call WriteInt
    call Crlf

    ; Print final amount after taxes
    mov edx, OFFSET final_amount_msg
    call WriteString
    mov eax, final_amount
    call WriteInt
    call Crlf

    ; Exit program
    invoke ExitProcess, 0
END START