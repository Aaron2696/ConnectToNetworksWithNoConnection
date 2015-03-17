package com.lewisjuggins.connecttonetworkswithnoconnection;

import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;
import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * Created by Lewis on 17/03/15.
 */
public class WifiMod implements IXposedHookLoadPackage
{

	@Override public void handleLoadPackage(final XC_LoadPackage.LoadPackageParam loadPackageParam)
			throws Throwable
	{
		if(!"android.net.wifi".equals(loadPackageParam.packageName))
			return;

		findAndHookMethod("android.net.wifi.WifiConfiguration", loadPackageParam.classLoader, "hasNoInternetAccess", new XC_MethodReplacement()
		{
			@Override protected Object replaceHookedMethod(final MethodHookParam methodHookParam)
					throws Throwable
			{
				return false;
			}
		});
	}
}
