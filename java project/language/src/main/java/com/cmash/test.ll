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
@.str0 = constant [10 x i8] c"Pass int:\00"
@.str1 = constant [18 x i8] c"(2 + 2 * 2) / 3 =\00"
@__const.Macierz.0 = constant [3 x [2 x i32]] [[2 x i32] [i32 4, i32 1], [2 x i32] [i32 2, i32 1], [2 x i32] [i32 3, i32 1]]
@.Napis_str = constant [6 x i8] c"napis\00"
@.str2 = constant [19 x i8] c"We have two bools:\00"
@.str3 = constant [33 x i8] c"Lets make on them and operation:\00"
@.str4 = constant [32 x i8] c"Lets make on them or operation:\00"
@.str5 = constant [33 x i8] c"Lets make on them xor operation:\00"
@.str6 = constant [26 x i8] c"Lets make neg first bool:\00"
@.str7 = constant [48 x i8] c"And once again lets make on them xor operation:\00"

define i32 @Main() {
entry:
%MyBool0.addr = alloca i1
store i1 0, i1* %MyBool0.addr
%MyInt.addr = alloca i32
store i32 1, i32* %MyInt.addr
%MyFloat.addr = alloca float, align 4
store double 1.2 , double* @doubleToFloat

%t0= load double, double* @doubleToFloat

%t1= fptrunc double %t0 to float
store float %t1, float* %MyFloat.addr

%MyDouble.addr = alloca double, align 8
store double 4.32, double* %MyDouble.addr
; Entering IO statement
; Entering printArgs
%t2 = load i1, i1* %MyBool0.addr
; Exiting printArgs with 1 arguments
%t3 = select i1 %t2, i8* getelementptr inbounds ([5 x i8], [5 x i8]* @trueStr, i32 0, i32 0), i8* getelementptr inbounds ([6 x i8], [6 x i8]* @falseStr, i32 0, i32 0)
call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strs, i32 0, i32 0), i8* %t3)
; Entering IO statement
; Entering printArgs
%t4 = load i32, i32* %MyInt.addr
; Exiting printArgs with 1 arguments
call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %t4)
; Entering IO statement
; Entering printArgs
%t5 = load float, float* %MyFloat.addr
; Exiting printArgs with 1 arguments
%t6= fpext float %t5 to double

call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([5 x i8], [5 x i8]* @strlf, i32 0, i32 0), double %t6)

; Entering IO statement
; Entering printArgs
%t7 = load double, double* %MyDouble.addr
; Exiting printArgs with 1 arguments
call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([5 x i8], [5 x i8]* @strlf, i32 0, i32 0), double %t7)
; Entering IO statement
; Entering printArgs
; Exiting printArgs with 1 arguments
call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strs, i32 0, i32 0), i8* @.str0)
; Entering IO statement
; Read token MyInt

%t8 = load i32, i32* %MyInt.addr
call i32 (i8*, ...) @scanf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @strd_in, i32 0, i32 0), i32* %MyInt.addr)
; Entering IO statement
; Entering printArgs
%t9 = load i32, i32* %MyInt.addr
; Exiting printArgs with 1 arguments
call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %t9)
; Entering IO statement
; Entering printArgs
; Exiting printArgs with 1 arguments
call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strs, i32 0, i32 0), i8* @.str1)
%t10 = mul i32 2, 2
%t11 = add i32 2, %t10
%t12 = sdiv i32 %t11, 3
store i32 %t12, i32* %MyInt.addr
; Evaluated expression statement, result in %t12
; Entering IO statement
; Entering printArgs
%t13 = load i32, i32* %MyInt.addr
; Exiting printArgs with 1 arguments
call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %t13)
%Macierz = alloca [3 x [2 x i32]]
%t14 = bitcast [3 x [2 x i32]]* %Macierz to i8*
%t15 = bitcast [3 x [2 x i32]]* @__const.Macierz.0 to i8*
call void @llvm.memcpy.p0i8.p0i8.i64(i8* %t14, i8* %t15, i64 24, i1 false)
%Tablica = alloca [4 x double]
%Napis = alloca [6 x i8], align 1
%t16 = bitcast [6 x i8]* %Napis to i8*
%t17 = bitcast [6 x i8]* @.Napis_str to i8*
call void @llvm.memcpy.p0i8.p0i8.i64(i8* %t16, i8* %t17, i64 6, i1 false)
%MyBool1.addr = alloca i1
store i1 1, i1* %MyBool1.addr
%Result.addr = alloca i1
; Entering IO statement
; Entering printArgs
; Exiting printArgs with 1 arguments
call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strs, i32 0, i32 0), i8* @.str2)
; Entering IO statement
; Entering printArgs
%t18 = load i1, i1* %MyBool0.addr
; Exiting printArgs with 1 arguments
%t19 = select i1 %t18, i8* getelementptr inbounds ([5 x i8], [5 x i8]* @trueStr, i32 0, i32 0), i8* getelementptr inbounds ([6 x i8], [6 x i8]* @falseStr, i32 0, i32 0)
call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strs, i32 0, i32 0), i8* %t19)
; Entering IO statement
; Entering printArgs
%t20 = load i1, i1* %MyBool1.addr
; Exiting printArgs with 1 arguments
%t21 = select i1 %t20, i8* getelementptr inbounds ([5 x i8], [5 x i8]* @trueStr, i32 0, i32 0), i8* getelementptr inbounds ([6 x i8], [6 x i8]* @falseStr, i32 0, i32 0)
call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strs, i32 0, i32 0), i8* %t21)
; Entering IO statement
; Entering printArgs
; Exiting printArgs with 1 arguments
call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strs, i32 0, i32 0), i8* @.str3)
%t22 = load i1, i1* %MyBool0.addr
%t23 = load i1, i1* %MyBool1.addr
br i1 %t22, label %label0, label %label1
label0:
br label %label1
label1:
%t24 = phi i1 [ 0, %entry ], [ %t23, %label0 ]
store i1 %t24, i1* %Result.addr
; Evaluated expression statement, result in %t24
; Entering IO statement
; Entering printArgs
%t25 = load i1, i1* %Result.addr
; Exiting printArgs with 1 arguments
%t26 = select i1 %t25, i8* getelementptr inbounds ([5 x i8], [5 x i8]* @trueStr, i32 0, i32 0), i8* getelementptr inbounds ([6 x i8], [6 x i8]* @falseStr, i32 0, i32 0)
call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strs, i32 0, i32 0), i8* %t26)
; Entering IO statement
; Entering printArgs
; Exiting printArgs with 1 arguments
call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strs, i32 0, i32 0), i8* @.str4)
%t27 = load i1, i1* %MyBool0.addr
%t28 = load i1, i1* %MyBool1.addr
br i1 %t27, label %label3, label %label2
label2:
br label %label3
label3:
%t29 = phi i1 [ 1, %label1 ], [ %t28, %label2 ]
store i1 %t29, i1* %Result.addr
; Evaluated expression statement, result in %t29
; Entering IO statement
; Entering printArgs
%t30 = load i1, i1* %Result.addr
; Exiting printArgs with 1 arguments
%t31 = select i1 %t30, i8* getelementptr inbounds ([5 x i8], [5 x i8]* @trueStr, i32 0, i32 0), i8* getelementptr inbounds ([6 x i8], [6 x i8]* @falseStr, i32 0, i32 0)
call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strs, i32 0, i32 0), i8* %t31)
; Entering IO statement
; Entering printArgs
; Exiting printArgs with 1 arguments
call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strs, i32 0, i32 0), i8* @.str5)
%t32 = load i1, i1* %MyBool0.addr
%t33 = load i1, i1* %MyBool1.addr
%t34 = xor i1 %t32, %t33
store i1 %t34, i1* %Result.addr
; Evaluated expression statement, result in %t34
; Entering IO statement
; Entering printArgs
%t35 = load i1, i1* %Result.addr
; Exiting printArgs with 1 arguments
%t36 = select i1 %t35, i8* getelementptr inbounds ([5 x i8], [5 x i8]* @trueStr, i32 0, i32 0), i8* getelementptr inbounds ([6 x i8], [6 x i8]* @falseStr, i32 0, i32 0)
call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strs, i32 0, i32 0), i8* %t36)
; Entering IO statement
; Entering printArgs
; Exiting printArgs with 1 arguments
call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strs, i32 0, i32 0), i8* @.str6)
%t37 = load i1, i1* %MyBool0.addr
%t38 = xor i1 %t37, 1
store i1 %t38, i1* %MyBool0.addr
; Evaluated expression statement, result in %t38
; Entering IO statement
; Entering printArgs
%t39 = load i1, i1* %MyBool0.addr
; Exiting printArgs with 1 arguments
%t40 = select i1 %t39, i8* getelementptr inbounds ([5 x i8], [5 x i8]* @trueStr, i32 0, i32 0), i8* getelementptr inbounds ([6 x i8], [6 x i8]* @falseStr, i32 0, i32 0)
call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strs, i32 0, i32 0), i8* %t40)
; Entering IO statement
; Entering printArgs
; Exiting printArgs with 1 arguments
call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strs, i32 0, i32 0), i8* @.str7)
%t41 = load i1, i1* %MyBool0.addr
%t42 = load i1, i1* %MyBool1.addr
%t43 = xor i1 %t41, %t42
store i1 %t43, i1* %Result.addr
; Evaluated expression statement, result in %t43
; Entering IO statement
; Entering printArgs
%t44 = load i1, i1* %Result.addr
; Exiting printArgs with 1 arguments
%t45 = select i1 %t44, i8* getelementptr inbounds ([5 x i8], [5 x i8]* @trueStr, i32 0, i32 0), i8* getelementptr inbounds ([6 x i8], [6 x i8]* @falseStr, i32 0, i32 0)
call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strs, i32 0, i32 0), i8* %t45)
ret i32 0
}

define i32 @main() nounwind{
%res = call i32 @Main()
ret i32 0 }