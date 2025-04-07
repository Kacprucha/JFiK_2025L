;i32 1
;double 3.0
;double 1.0
;i32 %t3
;double %t5
;float %t7
;i32 0
declare i32 @printf(i8*, ...)
declare i32 @scanf(i8*, ...)
@strp = constant [4 x i8] c"%d\0A\00"
@strs = constant [4 x i8] c"%s\0A\00" 
@strpi = constant [4 x i8] c"%d\0A\00"
@strpd = constant [4 x i8] c"%f\0A\00"
@strd = constant [4 x i8] c"%d\0A\00"
@strf = constant [4 x i8] c"%f\0A\00"
@strlf = constant [5 x i8] c"%lf\0A\00", align 1
@strs_in = constant [3 x i8] c"%d\00"
@strd_in = constant [3 x i8] c"%d\00" 
@strf_in = constant [3 x i8] c"%f\00" 
@strlf_in = constant [4 x i8] c"%lf\00" 
@doubleToFloat = global double 0.0

define i32 @Maine() {
%MyInt.addr = alloca i32
store i32 1, i32* %MyInt.addr
%MyDouble.addr = alloca double, align 8
store double 3.0, double* %MyDouble.addr
%MyFloat.addr = alloca float, align 4
store double 1.0 , double* @doubleToFloat

%t0= load double, double* @doubleToFloat

%t1= fptrunc double %t0 to float
store float %t1, float* %MyFloat.addr

; Entering IO statement
; Read token MyInt

%t2 = load i32, i32* %MyInt.addr
call i32 (i8*, ...) @scanf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @strd_in, i32 0, i32 0), i32* %MyInt.addr)
; Entering IO statement
; Entering printArgs
%t3 = load i32, i32* %MyInt.addr
; Exiting printArgs with 1 arguments
call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %t3)
; Entering IO statement
; Read token MyDouble

%t4 = load double, double* %MyDouble.addr
call i32 (i8*, ...) @scanf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strlf_in, i32 0, i32 0), double* %MyDouble.addr)
; Entering IO statement
; Entering printArgs
%t5 = load double, double* %MyDouble.addr
; Exiting printArgs with 1 arguments
call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([5 x i8], [5 x i8]* @strlf, i32 0, i32 0), double %t5)
; Entering IO statement
; Read token MyFloat

%t6 = load float, float* %MyFloat.addr
call i32 (i8*, ...) @scanf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @strf_in, i32 0, i32 0), float* %MyFloat.addr)
; Entering IO statement
; Entering printArgs
%t7 = load float, float* %MyFloat.addr
; Exiting printArgs with 1 arguments
%t8= fpext float %t7 to double 

call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([5 x i8], [5 x i8]* @strlf, i32 0, i32 0), double %t8)

ret i32 0
}

define i32 @main() nounwind{
%res = call i32 @Maine()
ret i32 0 }

