package gamehunt.gcore.hooks;

import gamehunt.hooklib.minecraft.HookLoader;
import gamehunt.hooklib.minecraft.PrimaryClassTransformer;

//Override this

public abstract class GCoreHookLoader extends HookLoader{
	
	
	
	@Override
	 public String[] getASMTransformerClass() {
	     return new String[]{PrimaryClassTransformer.class.getName()};
	 }
	
	public abstract String getHooksClass();

	
	@Override
	protected void registerHooks() {
		// TODO Auto-generated method stub
		 registerHookContainer(getHooksClass());
	}

}
