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
@doubleToFloat = global double 0.0
@.S_str = constant [4 x i8] c"Abc\00"

define i32 @Maine() {
%X = alloca [2 x [4 x i32]]
%A = alloca [1 x [2 x [4 x i8]]]
%S = alloca [4 x i8], align 1
%t0 = bitcast [4 x i8]* %S to i8*
%t1 = bitcast [4 x i8]* @.S_str to i8*
call void @llvm.memcpy.p0i8.p0i8.i64(i8* %t0, i8* %t1, i64 4, i1 false)
ret i32 0
}

define i32 @main() nounwind{
%res = call i32 @Maine()
ret i32 0 }

