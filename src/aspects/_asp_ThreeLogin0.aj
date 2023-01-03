package aspects;

import larva.*;
public aspect _asp_ThreeLogin0 {

public static Object lock = new Object();

boolean initialized = false;

after():(staticinitialization(*)){
if (!initialized){
	initialized = true;
	_cls_ThreeLogin0.initialize();
}
}
before () : (call(* *.PostedIncorrectly(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_ThreeLogin0.lock){

_cls_ThreeLogin0 _cls_inst = _cls_ThreeLogin0._get_cls_ThreeLogin0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 62/*PostedIncorrectly*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 62/*PostedIncorrectly*/);
}
}
before () : (call(* *.PostedSuccesfully(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_ThreeLogin0.lock){

_cls_ThreeLogin0 _cls_inst = _cls_ThreeLogin0._get_cls_ThreeLogin0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 60/*PostedSuccesfully*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 60/*PostedSuccesfully*/);
}
}
}