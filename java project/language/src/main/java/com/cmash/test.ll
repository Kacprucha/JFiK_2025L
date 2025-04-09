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

define i32 @Maine() {
entry:
%Res.addr = alloca i1
store i1 0, i1* %Res.addr
%Res2.addr = alloca i1
store i1 1, i1* %Res2.addr
%Res3.addr = alloca i1
%t0 = load i1, i1* %Res.addr
%t1 = load i1, i1* %Res2.addr
%t2 = xor i1 %t0, %t1
store i1 %t2, i1* %Res3.addr
; Evaluated expression statement, result in %t2
; Entering IO statement
; Entering printArgs
%t3 = load i1, i1* %Res3.addr
; Exiting printArgs with 1 arguments
%t4 = select i1 %t3, i8* getelementptr inbounds ([5 x i8], [5 x i8]* @trueStr, i32 0, i32 0), i8* getelementptr inbounds ([6 x i8], [6 x i8]* @falseStr, i32 0, i32 0)
call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strs, i32 0, i32 0), i8* %t4)
store i1 0, i1* %Res2.addr
; Evaluated expression statement, result in 0
%t5 = load i1, i1* %Res.addr
%t6 = load i1, i1* %Res2.addr
%t7 = xor i1 %t5, %t6
store i1 %t7, i1* %Res3.addr
; Evaluated expression statement, result in %t7
; Entering IO statement
; Entering printArgs
%t8 = load i1, i1* %Res3.addr
; Exiting printArgs with 1 arguments
%t9 = select i1 %t8, i8* getelementptr inbounds ([5 x i8], [5 x i8]* @trueStr, i32 0, i32 0), i8* getelementptr inbounds ([6 x i8], [6 x i8]* @falseStr, i32 0, i32 0)
call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strs, i32 0, i32 0), i8* %t9)
%t10 = load i1, i1* %Res2.addr
%t11 = xor i1 %t10, 1
store i1 %t11, i1* %Res3.addr
; Evaluated expression statement, result in %t11
; Entering IO statement
; Entering printArgs
%t12 = load i1, i1* %Res3.addr
; Exiting printArgs with 1 arguments
%t13 = select i1 %t12, i8* getelementptr inbounds ([5 x i8], [5 x i8]* @trueStr, i32 0, i32 0), i8* getelementptr inbounds ([6 x i8], [6 x i8]* @falseStr, i32 0, i32 0)
call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strs, i32 0, i32 0), i8* %t13)
ret i32 0
}

define i32 @main() nounwind{
%res = call i32 @Maine()
ret i32 0 }