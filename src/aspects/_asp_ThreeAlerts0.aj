package aspects;

import larva.*;
public aspect _asp_ThreeAlerts0 {

public static Object lock = new Object();

boolean initialized = false;

after():(staticinitialization(*)){
if (!initialized){
	initialized = true;
	_cls_ThreeAlerts0.initialize();
}
}
before () : (call(* *.ContainsAllInfo(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_ThreeAlerts0.lock){

_cls_ThreeAlerts0 _cls_inst = _cls_ThreeAlerts0._get_cls_ThreeAlerts0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 10/*ContainsAllInfo*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 10/*ContainsAllInfo*/);
}
}
before () : (call(* *.MissingInfo(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_ThreeAlerts0.lock){

_cls_ThreeAlerts0 _cls_inst = _cls_ThreeAlerts0._get_cls_ThreeAlerts0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 12/*MissingInfo*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 12/*MissingInfo*/);
}
}
before () : (call(* *.DeleteAndPostedSuccesfully(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_ThreeAlerts0.lock){

_cls_ThreeAlerts0 _cls_inst = _cls_ThreeAlerts0._get_cls_ThreeAlerts0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 6/*DeleteAndPostedSuccesfully*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 6/*DeleteAndPostedSuccesfully*/);
}
}
before () : (call(* *.checkAlertProperties(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_ThreeAlerts0.lock){

_cls_ThreeAlerts0 _cls_inst = _cls_ThreeAlerts0._get_cls_ThreeAlerts0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 14/*checkAlertProperties*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 14/*checkAlertProperties*/);
}
}
before () : (call(* *.PostedIncorrectly(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_ThreeAlerts0.lock){

_cls_ThreeAlerts0 _cls_inst = _cls_ThreeAlerts0._get_cls_ThreeAlerts0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 8/*PostedIncorrectly*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 8/*PostedIncorrectly*/);
}
}
}