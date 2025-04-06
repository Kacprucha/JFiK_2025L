declare i32 @printf(i8*, ...)
declare i32 @__isoc99_scanf(i8*, ...)
@strp = constant [4 x i8] c"%d\0A\00"
@strs = constant [4 x i8] c"%s\0A\00"
@strpi = constant [4 x i8] c"%d\0A\00"
@strpd = constant [4 x i8] c"%f\0A\00"
@strd = constant [4 x i8] c"%d\0A\00"
@strf = constant [4 x i8] c"%f\0A\00"
@strlf = constant [5 x i8] c"%lf\0A\00"
@strs_in = constant [3 x i8] c"%d\00"

define i32 @Maine() {
%MyInt.addr = alloca i32
store i32 1, i32* %MyInt.addr
%MyDouble.addr = alloca double, align 8
store double 4.98, double* %MyDouble.addr
; Entering IO statement
; Entering printArgs
%t0 = load i32, i32* %MyInt.addr
; Exiting printArgs with 1 arguments
call i32 @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %t0)
; Entering IO statement
; Entering printArgs
%t1 = load double, double* %MyDouble.addr
; Exiting printArgs with 1 arguments
call i32 @printf(i8* getelementptr inbounds ([5 x i8], [5 x i8]* @strlf, i32 0, i32 0), double 4.980000e+00)
ret i32 0
}

define i32 @main() nounwind{
%res = call i32 @Maine()
ret i32 0 }