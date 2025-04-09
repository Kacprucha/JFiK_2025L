;i32 2
;i32 %t3
;i32 0
declare void @llvm.memcpy.p0i8.p0i8.i64(i8* nocapture writeonly, i8* nocapture readonly, i64, i1 immarg)
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
@space = constant [2 x i8] c" \00"
@newline = constant [2 x i8] c"\0A\00"
@doubleToFloat = global double 0.0
@__const.X.0 = constant [3 x [2 x i32]] [[2 x i32] [i32 4, i32 1], [2 x i32] [i32 2, i32 1], [2 x i32] [i32 3, i32 1]]

define i32 @Maine() {
%X = alloca [3 x [2 x i32]]
%t0 = bitcast [3 x [2 x i32]]* %X to i8*
%t1 = bitcast [3 x [2 x i32]]* @__const.X.0 to i8*
call void @llvm.memcpy.p0i8.p0i8.i64(i8* %t0, i8* %t1, i64 24, i1 false)
%Y.addr = alloca i32
store i32 2, i32* %Y.addr
; Entering IO statement
; Read token Y

%t2 = load i32, i32* %Y.addr
call i32 (i8*, ...) @scanf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @strd_in, i32 0, i32 0), i32* %Y.addr)
; Entering IO statement
; Entering printArgs
%t3 = load i32, i32* %Y.addr
; Exiting printArgs with 1 arguments
call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %t3)
ret i32 0
}

define i32 @main() nounwind{
%res = call i32 @Maine()
ret i32 0 }

