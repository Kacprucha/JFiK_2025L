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
%MyFloat.addr = alloca double, align 8
store double 7.0, double* %MyFloat.addr
%Float2.addr = alloca double, align 8
store double 2.0, double* %Float2.addr
%t0 = fadd float 0x40E00000, 0x3E4CCCCD
%Float3.addr = alloca float, align 4
store double %t0 , double* @doubleToFloat

%t1= load double, double* @doubleToFloat

%t2= fptrunc double %t1 to float
store float %t2, float* %Float3.addr

; Entering IO statement
; Entering printArgs
%t3 = load float, float* %Float3.addr
; Exiting printArgs with 1 arguments
%t4= fpext float %t3 to double

call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([5 x i8], [5 x i8]* @strlf, i32 0, i32 0), double %t4)

ret i32 0
}

define i32 @main() nounwind{
%res = call i32 @Maine()
ret i32 0 }