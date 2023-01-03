package larva;


import java.util.LinkedHashMap;
import java.io.PrintWriter;

public class _cls_ThreeLogin0 implements _callable{

public static PrintWriter pw; 
public static _cls_ThreeLogin0 root;

public static LinkedHashMap<_cls_ThreeLogin0,_cls_ThreeLogin0> _cls_ThreeLogin0_instances = new LinkedHashMap<_cls_ThreeLogin0,_cls_ThreeLogin0>();
static{
try{
RunningClock.start();
pw = new PrintWriter("C:\\Users\\user\\workspace\\AssignmentTwo/src/output_ThreeLogin.txt");

root = new _cls_ThreeLogin0();
_cls_ThreeLogin0_instances.put(root, root);
  root.initialisation();
}catch(Exception ex)
{ex.printStackTrace();}
}

_cls_ThreeLogin0 parent; //to remain null - this class does not have a parent!
int no_automata = 1;

public static void initialize(){}
//inheritance could not be used because of the automatic call to super()
//when the constructor is called...we need to keep the SAME parent if this exists!

public _cls_ThreeLogin0() {
}

public void initialisation() {
}

public static _cls_ThreeLogin0 _get_cls_ThreeLogin0_inst() { synchronized(_cls_ThreeLogin0_instances){
 return root;
}
}

public boolean equals(Object o) {
 if ((o instanceof _cls_ThreeLogin0))
{return true;}
else
{return false;}
}

public int hashCode() {
return 0;
}

public void _call(String _info, int... _event){
synchronized(_cls_ThreeLogin0_instances){
_performLogic_Alerts(_info, _event);
}
}

public void _call_all_filtered(String _info, int... _event){
}

public static void _call_all(String _info, int... _event){

_cls_ThreeLogin0[] a = new _cls_ThreeLogin0[1];
synchronized(_cls_ThreeLogin0_instances){
a = _cls_ThreeLogin0_instances.keySet().toArray(a);}
for (_cls_ThreeLogin0 _inst : a)

if (_inst != null) _inst._call(_info, _event);
}

public void _killThis(){
try{
if (--no_automata == 0){
synchronized(_cls_ThreeLogin0_instances){
_cls_ThreeLogin0_instances.remove(this);}
}
else if (no_automata < 0)
{throw new Exception("no_automata < 0!!");}
}catch(Exception ex){ex.printStackTrace();}
}

int _state_id_Alerts = 46;

public void _performLogic_Alerts(String _info, int... _event) {

_cls_ThreeLogin0.pw.println("[Alerts]AUTOMATON::> Alerts("+") STATE::>"+ _string_Alerts(_state_id_Alerts, 0));
_cls_ThreeLogin0.pw.flush();

if (0==1){}
else if (_state_id_Alerts==46){
		if (1==0){}
		else if ((_occurredEvent(_event,60/*PostedSuccesfully*/))){
		_cls_ThreeLogin0.pw .println ("Correct number of posts have been made");

		_state_id_Alerts = 44;//moving to state CorrectNumberOfAlerts
		_goto_Alerts(_info);
		}
		else if ((_occurredEvent(_event,62/*PostedIncorrectly*/))){
		_cls_ThreeLogin0.pw .println ("ERROR! : InCorrect number of posts have been made");

		_state_id_Alerts = 45;//moving to state InCorrectNumberOfAlerts
		_goto_Alerts(_info);
		}
}
}

public void _goto_Alerts(String _info){
_cls_ThreeLogin0.pw.println("[Alerts]MOVED ON METHODCALL: "+ _info +" TO STATE::> " + _string_Alerts(_state_id_Alerts, 1));
_cls_ThreeLogin0.pw.flush();
}

public String _string_Alerts(int _state_id, int _mode){
switch(_state_id){
case 44: if (_mode == 0) return "CorrectNumberOfAlerts"; else return "(((SYSTEM REACHED AN ACCEPTED STATE)))  CorrectNumberOfAlerts";
case 45: if (_mode == 0) return "InCorrectNumberOfAlerts"; else return "(((SYSTEM REACHED AN ACCEPTED STATE)))  InCorrectNumberOfAlerts";
case 46: if (_mode == 0) return "ViewingAlerts"; else return "ViewingAlerts";
default: return "!!!SYSTEM REACHED AN UNKNOWN STATE!!!";
}
}

public boolean _occurredEvent(int[] _events, int event){
for (int i:_events) if (i == event) return true;
return false;
}
}