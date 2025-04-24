declare void @llvm.memcpy.p0i8.p0i8.i64(i8* nocapture writeonly, i8* nocapture readonly, i64, i1 immarg)
declare i32 @printf(i8*, ...)
declare i32 @scanf(i8*, ...)
@trueStr  = constant [5 x i8] c"true\00"
@falseStr = constant [6 x i8] c"false\00"
@strp = constant [4 x i8] c"%d\0A\00"
@strs = constant [4 x i8] c"%s\0A\00"
@strpi = constant [4 x i8] c"%d\0A\00"
@strpd = constant [4 x i8] c"%f\0A\00"
@strd = constant [4 x i8] c"%d\0A\00"
@strf = constant [4 x i8] c"%f\0A\00"
@strlf = constant [5 x i8] c"%lf\0A\00", align 1
@strb = constant [4 x i8] c"%d\0A\00"
@strs_in = constant [3 x i8] c"%d\00"
@strd_in = constant [3 x i8] c"%d\00"
@strf_in = constant [3 x i8] c"%f\00"
@strlf_in = constant [4 x i8] c"%lf\00"
@space = constant [2 x i8] c" \00"
@newline = constant [2 x i8] c"\0A\00"
@doubleToFloat = global double 0.0
@.str0 = constant [9 x i8] c"Printer:\00"

define void @Newprinter(double %Text) {
entry:
%Text.addr = alloca double
store double %Text, double* %Text.addr
%t0 = load double, double* %Text.addr
; Entering IO statement
; Exiting printArgs with 1 arguments
call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strs, i32 0, i32 0), i8* @.str0)
; Entering IO statement
%t1 = load double, double* %Text.addr
; Exiting printArgs with 1 arguments
call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([5 x i8], [5 x i8]* @strlf, i32 0, i32 0), double %t1)
ret void
}

define i32 @Main() {
entry:
%Test.addr = alloca double, align 8
store double 6.9, double* %Test.addr
%t2 = load double, double* %Test.addr
call void @Newprinter(double %t2)
; Evaluated expression statement, result in
ret i32 0
}

define i32 @main() nounwind{
%res = call i32 @Main()
ret i32 0 }