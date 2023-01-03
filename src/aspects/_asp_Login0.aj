package aspects;

import larva.*;
public aspect _asp_Login0 {

public static Object lock = new Object();

boolean initialized = false;

after():(staticinitialization(*)){
if (!initialized){
	initialized = true;
	_cls_Login0.initialize();
}
}
before () : (call(* *.LoggedOut(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_Login0.lock){

_cls_Login0 _cls_inst = _cls_Login0._get_cls_Login0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 78/*LoggedOut*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 78/*LoggedOut*/);
}
}
before () : (call(* *.viewAlerts(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_Login0.lock){

_cls_Login0 _cls_inst = _cls_Login0._get_cls_Login0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 76/*viewAlerts*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 76/*viewAlerts*/);
}
}
before () : (call(* *.incorrectLogin(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_Login0.lock){

_cls_Login0 _cls_inst = _cls_Login0._get_cls_Login0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 74/*incorrectLogin*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 74/*incorrectLogin*/);
}
}
before () : (call(* *.correctLogin(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_Login0.lock){

_cls_Login0 _cls_inst = _cls_Login0._get_cls_Login0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 72/*correctLogin*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 72/*correctLogin*/);
}
}
}