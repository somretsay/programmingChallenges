
.data
jobCount DWORD 0
totalIncome REAL4 0.0
totalFederalTax REAL4 0.0
totalStateTax REAL4 0.0

promptJob BYTE "Enter income for job #", 0
promptStateTax BYTE "Enter state tax rate (in percentage) for job #", 0
errorMsg BYTE "Invalid input! Please enter a non-negative number.", 0
federalTaxRate REAL4 0.185
stateTaxRate REAL4 0.0875

.code
main PROC
    mov jobCount, 1      ; Start with job #1

    ; Loop to get income for each job
    mov ecx, 2           ; Loop counter, number of jobs to input
    call GetIncomeLoop

    ; Calculate and print total taxes
    call CalculateTaxes
    call PrintTotalTaxes

    exit
main ENDP

; Function to get income for each job
GetIncomeLoop PROC
    ; Loop through for each job
    L1:
    mov edx, OFFSET promptJob
    call WriteString

    ; Print job number
    mov eax, jobCount
    call WriteDec

    ; Get income input from user
    call GetIncome
    add totalIncome, eax

    ; Get state tax rate input from user
    mov edx, OFFSET promptStateTax
    call WriteString
    mov eax, jobCount
    call WriteDec
    mov edx, OFFSET errorMsg
    call WriteString
    call GetTaxRate
    call CalculateTaxesForJob

    inc jobCount

    loop L1

    ret
GetIncomeLoop ENDP

; Function to get income input from user
GetIncome PROC
    mov edx, OFFSET errorMsg
    call WriteString

    ; Read user input
    call ReadFloat
    cmp eax, 0        ; Check if input is negative
    jl GetIncome      ; If negative, prompt again

    ret
GetIncome ENDP

; Function to get state tax rate input from user
GetTaxRate PROC
    mov edx, OFFSET errorMsg
    call WriteString

    ; Read user input
    call ReadFloat
    cmp eax, 0        ; Check if input is negative
    jl GetTaxRate     ; If negative, prompt again

    ; Convert percentage to decimal
    fdiv DWORD PTR 100.0

    ret
GetTaxRate ENDP

; Function to calculate taxes for each job
CalculateTaxesForJob PROC
    ; Calculate federal tax
    fmul federalTaxRate
    fstp totalFederalTax

    ; Calculate state tax
    fmul ST(0), stateTaxRate
    fstp totalStateTax

    ret
CalculateTaxesForJob ENDP

; Function to calculate total taxes
CalculateTaxes PROC
    ; Calculate total federal tax
    fmul totalIncome, federalTaxRate
    fstp totalFederalTax

    ; Calculate total state tax
    fmul totalIncome, stateTaxRate
    fstp totalStateTax

    ret
CalculateTaxes ENDP

; Function to print total taxes
PrintTotalTaxes PROC
    ; Print total federal tax
    mov edx, OFFSET errorMsg
    call WriteString
    mov edx, OFFSET errorMsg
    call WriteString

    ; Print total state tax
    mov edx, OFFSET errorMsg
    call WriteString

    ret
PrintTotalTaxes ENDP

END main