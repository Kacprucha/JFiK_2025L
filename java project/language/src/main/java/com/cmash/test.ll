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
@.str0 = constant [16 x i8] c"Beggingin value\00"
@.str1 = constant [17 x i8] c"Endggingin value\00"
@.str2 = constant [17 x i8] c"Beggingin result\00"
@.str3 = constant [18 x i8] c"Endggingin result\00"

define void @Adding(i32 %Value, i32 %Iterations) {
entry:
%Value.addr = alloca i32
store i32 %Value, i32* %Value.addr
%Iterations.addr = alloca i32
store i32 %Iterations, i32* %Iterations.addr
%t0 = load i32, i32* %Value.addr
%t1 = load i32, i32* %Iterations.addr
; Entering IO statement
; Exiting printArgs with 1 arguments
call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strs, i32 0, i32 0), i8* @.str0)
; Entering IO statement
%t2 = load i32, i32* %Value.addr
; Exiting printArgs with 1 arguments
call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %t2)
%Iter.addr = alloca i32
store i32 0, i32* %Iter.addr
br label %label1
label1:
%t3 = load i32, i32* %Iter.addr
%t4 = load i32, i32* %Iterations.addr
%t5 = icmp slt i32 %t3, %t4
br i1 %t5, label %label2, label %label4
label2:
%t6 = load i32, i32* %Iter.addr
%t7 = add i32 %t6, 1
store i32 %t7, i32* %Iter.addr
%t8 = load i32, i32* %Value.addr
%t9 = add i32 %t8, 1
store i32 %t9, i32* %Value.addr
; Evaluated expression statement, result in %t9
br label %label3
label3:
br label %label1
label4:
; Entering IO statement
; Exiting printArgs with 1 arguments
call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strs, i32 0, i32 0), i8* @.str1)
; Entering IO statement
%t10 = load i32, i32* %Value.addr
; Exiting printArgs with 1 arguments
call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %t10)
ret void
}

define i32 @Main() {
entry:
%MyInt.addr = alloca i32
; Entering IO statement
; Read token MyInt

%t11 = load i32, i32* %MyInt.addr
call i32 (i8*, ...) @scanf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @strd_in, i32 0, i32 0), i32* %MyInt.addr)
%Resoult.addr = alloca i32
store i32 0, i32* %Resoult.addr
; Entering IO statement
; Exiting printArgs with 1 arguments
call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strs, i32 0, i32 0), i8* @.str2)
; Entering IO statement
%t12 = load i32, i32* %Resoult.addr
; Exiting printArgs with 1 arguments
call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %t12)
%t13 = load i32, i32* %Resoult.addr
%t14 = load i32, i32* %MyInt.addr
call void @Adding(i32 %t13, i32 %t14)
; Evaluated expression statement, result in
; Entering IO statement
; Exiting printArgs with 1 arguments
call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strs, i32 0, i32 0), i8* @.str3)
; Entering IO statement
%t15 = load i32, i32* %Resoult.addr
; Exiting printArgs with 1 arguments
call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %t15)
ret i32 0
}

define i32 @main() nounwind{
%res = call i32 @Main()
ret i32 0 }