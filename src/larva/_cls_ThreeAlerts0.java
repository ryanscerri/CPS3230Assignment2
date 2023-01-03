package larva;


import java.util.LinkedHashMap;
import java.io.PrintWriter;

public class _cls_ThreeAlerts0 implements _callable{

public static PrintWriter pw; 
public static _cls_ThreeAlerts0 root;

public static LinkedHashMap<_cls_ThreeAlerts0,_cls_ThreeAlerts0> _cls_ThreeAlerts0_instances = new LinkedHashMap<_cls_ThreeAlerts0,_cls_ThreeAlerts0>();
static{
try{
RunningClock.start();
pw = new PrintWriter("C:\\Users\\user\\workspace\\AssignmentTwo/src/output_ThreeAlerts.txt");

root = new _cls_ThreeAlerts0();
_cls_ThreeAlerts0_instances.put(root, root);
  root.initialisation();
}catch(Exception ex)
{ex.printStackTrace();}
}

_cls_ThreeAlerts0 parent; //to remain null - this class does not have a parent!
int no_automata = 1;

public static void initialize(){}
//inheritance could not be used because of the automatic call to super()
//when the constructor is called...we need to keep the SAME parent if this exists!

public _cls_ThreeAlerts0() {
}

public void initialisation() {
}

public static _cls_ThreeAlerts0 _get_cls_ThreeAlerts0_inst() { synchronized(_cls_ThreeAlerts0_instances){
 return root;
}
}

public boolean equals(Object o) {
 if ((o instanceof _cls_ThreeAlerts0))
{return true;}
else
{return false;}
}

public int hashCode() {
return 0;
}

public void _call(String _info, int... _event){
synchronized(_cls_ThreeAlerts0_instances){
_performLogic_Alerts(_info, _event);
}
}

public void _call_all_filtered(String _info, int... _event){
}

public static void _call_all(String _info, int... _event){

_cls_ThreeAlerts0[] a = new _cls_ThreeAlerts0[1];
synchronized(_cls_ThreeAlerts0_instances){
a = _cls_ThreeAlerts0_instances.keySet().toArray(a);}
for (_cls_ThreeAlerts0 _inst : a)

if (_inst != null) _inst._call(_info, _event);
}

public void _killThis(){
try{
if (--no_automata == 0){
synchronized(_cls_ThreeAlerts0_instances){
_cls_ThreeAlerts0_instances.remove(this);}
}
else if (no_automata < 0)
{throw new Exception("no_automata < 0!!");}
}catch(Exception ex){ex.printStackTrace();}
}

int _state_id_Alerts = 9;

public void _performLogic_Alerts(String _info, int... _event) {

_cls_ThreeAlerts0.pw.println("[Alerts]AUTOMATON::> Alerts("+") STATE::>"+ _string_Alerts(_state_id_Alerts, 0));
_cls_ThreeAlerts0.pw.flush();

if (0==1){}
else if (_state_id_Alerts==7){
		if (1==0){}
		else if ((_occurredEvent(_event,14/*checkAlertProperties*/))){
		_cls_ThreeAlerts0.pw .println ("Alerts are being checked!");

		_state_id_Alerts = 8;//moving to state CheckingProperties
		_goto_Alerts(_info);
		}
}
else if (_state_id_Alerts==9){
		if (1==0){}
		else if ((_occurredEvent(_event,6/*DeleteAndPostedSuccesfully*/))){
		_cls_ThreeAlerts0.pw .println ("Correct number of DELETE and POST have been made");

		_state_id_Alerts = 7;//moving to state CorrectNumberOfDeleteAndAlerts
		_goto_Alerts(_info);
		}
		else if ((_occurredEvent(_event,8/*PostedIncorrectly*/))){
		_cls_ThreeAlerts0.pw .println ("ERROR! : InCorrect number of posts have been made");

		_state_id_Alerts = 4;//moving to state InCorrectNumberOfAlerts
		_goto_Alerts(_info);
		}
}
else if (_state_id_Alerts==8){
		if (1==0){}
		else if ((_occurredEvent(_event,10/*ContainsAllInfo*/))){
		_cls_ThreeAlerts0.pw .println ("Posts contain all info");

		_state_id_Alerts = 5;//moving to state ContainsAllInfo
		_goto_Alerts(_info);
		}
		else if ((_occurredEvent(_event,12/*MissingInfo*/))){
		_cls_ThreeAlerts0.pw .println ("Posts are missing info");

		_state_id_Alerts = 6;//moving to state MissingInfo
		_goto_Alerts(_info);
		}
}
}

public void _goto_Alerts(String _info){
_cls_ThreeAlerts0.pw.println("[Alerts]MOVED ON METHODCALL: "+ _info +" TO STATE::> " + _string_Alerts(_state_id_Alerts, 1));
_cls_ThreeAlerts0.pw.flush();
}

public String _string_Alerts(int _state_id, int _mode){
switch(_state_id){
case 4: if (_mode == 0) return "InCorrectNumberOfAlerts"; else return "(((SYSTEM REACHED AN ACCEPTED STATE)))  InCorrectNumberOfAlerts";
case 7: if (_mode == 0) return "CorrectNumberOfDeleteAndAlerts"; else return "CorrectNumberOfDeleteAndAlerts";
case 9: if (_mode == 0) return "ViewingAlerts"; else return "ViewingAlerts";
case 6: if (_mode == 0) return "MissingInfo"; else return "(((SYSTEM REACHED AN ACCEPTED STATE)))  MissingInfo";
case 8: if (_mode == 0) return "CheckingProperties"; else return "CheckingProperties";
case 5: if (_mode == 0) return "ContainsAllInfo"; else return "(((SYSTEM REACHED AN ACCEPTED STATE)))  ContainsAllInfo";
default: return "!!!SYSTEM REACHED AN UNKNOWN STATE!!!";
}
}

public boolean _occurredEvent(int[] _events, int event){
for (int i:_events) if (i == event) return true;
return false;
}
}