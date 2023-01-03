package larva;


import java.util.LinkedHashMap;
import java.io.PrintWriter;

public class _cls_Login0 implements _callable{

public static PrintWriter pw; 
public static _cls_Login0 root;

public static LinkedHashMap<_cls_Login0,_cls_Login0> _cls_Login0_instances = new LinkedHashMap<_cls_Login0,_cls_Login0>();
static{
try{
RunningClock.start();
pw = new PrintWriter("C:\\Users\\user\\workspace\\AssignmentTwo/src/output_Login.txt");

root = new _cls_Login0();
_cls_Login0_instances.put(root, root);
  root.initialisation();
}catch(Exception ex)
{ex.printStackTrace();}
}

_cls_Login0 parent; //to remain null - this class does not have a parent!
int no_automata = 1;

public static void initialize(){}
//inheritance could not be used because of the automatic call to super()
//when the constructor is called...we need to keep the SAME parent if this exists!

public _cls_Login0() {
}

public void initialisation() {
}

public static _cls_Login0 _get_cls_Login0_inst() { synchronized(_cls_Login0_instances){
 return root;
}
}

public boolean equals(Object o) {
 if ((o instanceof _cls_Login0))
{return true;}
else
{return false;}
}

public int hashCode() {
return 0;
}

public void _call(String _info, int... _event){
synchronized(_cls_Login0_instances){
_performLogic_login(_info, _event);
}
}

public void _call_all_filtered(String _info, int... _event){
}

public static void _call_all(String _info, int... _event){

_cls_Login0[] a = new _cls_Login0[1];
synchronized(_cls_Login0_instances){
a = _cls_Login0_instances.keySet().toArray(a);}
for (_cls_Login0 _inst : a)

if (_inst != null) _inst._call(_info, _event);
}

public void _killThis(){
try{
if (--no_automata == 0){
synchronized(_cls_Login0_instances){
_cls_Login0_instances.remove(this);}
}
else if (no_automata < 0)
{throw new Exception("no_automata < 0!!");}
}catch(Exception ex){ex.printStackTrace();}
}

int _state_id_login = 48;

public void _performLogic_login(String _info, int... _event) {

_cls_Login0.pw.println("[login]AUTOMATON::> login("+") STATE::>"+ _string_login(_state_id_login, 0));
_cls_Login0.pw.flush();

if (0==1){}
else if (_state_id_login==48){
		if (1==0){}
		else if ((_occurredEvent(_event,74/*incorrectLogin*/))){
		_cls_Login0.pw .println ("loggedOut -> BAD LOGIN");

		_state_id_login = 44;//moving to state BadLogin
		_goto_login(_info);
		}
		else if ((_occurredEvent(_event,72/*correctLogin*/))){
		_cls_Login0.pw .println ("loggedOut -> loggedIn");

		_state_id_login = 47;//moving to state loggedIn
		_goto_login(_info);
		}
}
else if (_state_id_login==46){
		if (1==0){}
		else if ((_occurredEvent(_event,78/*LoggedOut*/))){
		_cls_Login0.pw .println ("viewingAlerts -> LoggedOut");

		_state_id_login = 45;//moving to state LoggedOut
		_goto_login(_info);
		}
}
else if (_state_id_login==47){
		if (1==0){}
		else if ((_occurredEvent(_event,76/*viewAlerts*/))){
		_cls_Login0.pw .println ("loggedIn -> viewingAlerts");

		_state_id_login = 46;//moving to state viewingAlerts
		_goto_login(_info);
		}
}
}

public void _goto_login(String _info){
_cls_Login0.pw.println("[login]MOVED ON METHODCALL: "+ _info +" TO STATE::> " + _string_login(_state_id_login, 1));
_cls_Login0.pw.flush();
}

public String _string_login(int _state_id, int _mode){
switch(_state_id){
case 44: if (_mode == 0) return "BadLogin"; else return "(((SYSTEM REACHED AN ACCEPTED STATE)))  BadLogin";
case 46: if (_mode == 0) return "viewingAlerts"; else return "viewingAlerts";
case 48: if (_mode == 0) return "loggingIn"; else return "loggingIn";
case 47: if (_mode == 0) return "loggedIn"; else return "loggedIn";
case 45: if (_mode == 0) return "LoggedOut"; else return "(((SYSTEM REACHED AN ACCEPTED STATE)))  LoggedOut";
default: return "!!!SYSTEM REACHED AN UNKNOWN STATE!!!";
}
}

public boolean _occurredEvent(int[] _events, int event){
for (int i:_events) if (i == event) return true;
return false;
}
}