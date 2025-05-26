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
@.str0 = constant [9 x i8] c"Function\00"
%struct.RNG = type { i32 }
@.str1 = constant [11 x i8] c"Iteration:\00"
@.str2 = constant [12 x i8] c"Good choice\00"
@.str3 = constant [11 x i8] c"Pick again\00"
@.str4 = constant [29 x i8] c"Checking if save was correct\00"
@.str5 = constant [9 x i8] c"Function\00"
@.str6 = constant [12 x i8] c"Before loop\00"
@.str7 = constant [11 x i8] c"After loop\00"
@.str8 = constant [13 x i8] c"Cleaning ...\00"

define void @Function() {
entry:
; Entering IO statement
; Exiting printArgs with 1 arguments
call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strs, i32 0, i32 0), i8* @.str0)
ret void
}

define void @Adding(i32 %Value, i32 %Iterations) {
entry:
%Value.addr = alloca i32
store i32 %Value, i32* %Value.addr
%Iterations.addr = alloca i32
store i32 %Iterations, i32* %Iterations.addr
%t0 = load i32, i32* %Value.addr
%t1 = load i32, i32* %Iterations.addr
%Iter.addr = alloca i32
store i32 0, i32* %Iter.addr
br label %label1
label1:
%t2 = load i32, i32* %Iter.addr
%t3 = load i32, i32* %Iterations.addr
%t4 = icmp slt i32 %t2, %t3
br i1 %t4, label %label2, label %label4
label2:
%t5 = load i32, i32* %Iter.addr
%t6 = add i32 %t5, 1
store i32 %t6, i32* %Iter.addr
%t7 = load i32, i32* %Value.addr
%t8 = add i32 %t7, 1
store i32 %t8, i32* %Value.addr
; Evaluated expression statement, result in %t8
; Entering IO statement
; Exiting printArgs with 1 arguments
call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strs, i32 0, i32 0), i8* @.str1)
; Entering IO statement
%t9 = load i32, i32* %Value.addr
; Exiting printArgs with 1 arguments
call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %t9)
br label %label3
label3:
br label %label1
label4:
ret void
}

define i32 @Main() {
entry:
%MyInt.addr = alloca i32
; Entering IO statement
; Read token MyInt

%t10 = load i32, i32* %MyInt.addr
call i32 (i8*, ...) @scanf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @strd_in, i32 0, i32 0), i32* %MyInt.addr)
; Entering IF construct related to labels: then=label_then5 else=label_else7 merge=label_merge6
%t11 = load i32, i32* %MyInt.addr
%t12 = icmp eq i32 %t11, 4
; Condition for IF evaluated: %t12 (MyInt==4)
br i1 %t12, label %label_then5, label %label_else7
label_then5:
; THEN block starts for label_then5
; Entering IO statement
; Exiting printArgs with 1 arguments
call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strs, i32 0, i32 0), i8* @.str2)
; THEN block ends for label_then5
br label %label_merge6
label_else7:
; ELSE block starts for label_else7
; Entering IO statement
; Exiting printArgs with 1 arguments
call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strs, i32 0, i32 0), i8* @.str3)
; Entering IO statement
; Read token MyInt

%t13 = load i32, i32* %MyInt.addr
call i32 (i8*, ...) @scanf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @strd_in, i32 0, i32 0), i32* %MyInt.addr)
; ELSE block ends for label_else7
br label %label_merge6
label_merge6:
; IF construct ends, merged at label_merge6
%UserInput = alloca %struct.RNG
%t14 = getelementptr inbounds %struct.RNG, %struct.RNG* %UserInput, i32 0, i32 0
%t15 = load i32, i32* %MyInt.addr
store i32 %t15, i32* %t14
; Evaluated expression statement, result in %t15
; Entering IO statement
; Exiting printArgs with 1 arguments
call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strs, i32 0, i32 0), i8* @.str4)
; Entering IO statement
%t16 = getelementptr inbounds %struct.RNG, %struct.RNG* %UserInput, i32 0, i32 0
%t17 = load i32, i32* %t16
; Exiting printArgs with 1 arguments
call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %t17)
; Entering IO statement
; Exiting printArgs with 1 arguments
call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strs, i32 0, i32 0), i8* @.str5)
%Result.addr = alloca i32
store i32 0, i32* %Result.addr
; Entering IO statement
; Exiting printArgs with 1 arguments
call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strs, i32 0, i32 0), i8* @.str6)
; Entering IO statement
%t18 = load i32, i32* %Result.addr
; Exiting printArgs with 1 arguments
call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %t18)
%t19 = load i32, i32* %Result.addr
%t20 = load i32, i32* %MyInt.addr
call void @Adding(i32 %t19, i32 %t20)
; Evaluated expression statement, result in
; Entering IO statement
; Exiting printArgs with 1 arguments
call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strs, i32 0, i32 0), i8* @.str7)
; Entering IO statement
%t21 = load i32, i32* %Result.addr
; Exiting printArgs with 1 arguments
call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %t21)
; Entering IO statement
; Exiting printArgs with 1 arguments
call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strs, i32 0, i32 0), i8* @.str8)
br label %label8
label8:
%t22 = load i32, i32* %MyInt.addr
%t23 = icmp sgt i32 %t22, 0
br i1 %t23, label %label9, label %label10
label9:
%t24 = load i32, i32* %MyInt.addr
%t25 = sub i32 %t24, 1
store i32 %t25, i32* %MyInt.addr
; Evaluated expression statement, result in %t25
; Entering IO statement
%t26 = load i32, i32* %MyInt.addr
; Exiting printArgs with 1 arguments
call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %t26)
br label %label8
label10:
ret i32 0
}

define i32 @main() nounwind{
%res = call i32 @Main()
ret i32 0 }