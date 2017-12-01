package Tables;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Methods {
	public String type;
	public String id;
	public Map arg;
	public Map variavel;
	public int nivel;
	public int linha;
	
	public Methods()
	{
		type = new String();
		id = new String();
		arg = new LinkedHashMap();
		variavel = new LinkedHashMap();
		nivel = 0;
	}
	
	public void ident(int n)
	{
		for(int i = 0; i < nivel; i++)
		{
			System.out.print("\t");
		}
	}
	
	public void print()
	{
		ident(nivel);
		System.out.println("METHOD");
		ident(nivel);
		System.out.print(type + " " + id + " ");
		
		if(!arg.isEmpty())
		{
			System.out.print("ARGUMENTS ");
			Set ss = arg.entrySet();
			Iterator ii = ss.iterator();
			while(ii.hasNext())
			{
				Map.Entry entrada = (Map.Entry)ii.next();
				Variables a = (Variables)entrada.getValue();
				a.print(false);
				System.out.print(" ");
			}
		}
		
		if(!variavel.isEmpty())
		{		
			System.out.println("");
			Set ss = variavel.entrySet();
			Iterator ii = ss.iterator();
			while(ii.hasNext())
			{
				Map.Entry entrada = (Map.Entry)ii.next();
				Variables a = (Variables)entrada.getValue();
				a.nivel = nivel + 1;
				a.print(true);
			}
		}
		System.out.println("");
	}
	
	public void repeatVerifVar(Map classMap, String nomeClass)
	{	
		Classes myClass = (Classes)classMap.get(nomeClass);
		
		if(!variavel.isEmpty())
		{			
			Set ss = variavel.entrySet();
			Iterator ii = ss.iterator();
			while(ii.hasNext())
			{
				Map.Entry v = (Map.Entry)ii.next();
				Variables a = (Variables)v.getValue();
				if(arg.containsKey(a.id))
				{
					System.out.println("A variavel ( " + a.type + " " + a.id + " ) foi redefinida, em " + (a.linha + 1));
				}
			}
			
			if(myClass.variavel != null)
			{
				ss = variavel.entrySet();
				ii = ss.iterator();
				while(ii.hasNext())
				{
					Map.Entry v = (Map.Entry)ii.next();
					Variables a = (Variables)v.getValue();
					if(myClass.variavel.containsKey(a.id))
					    System.out.println("A variavel ( " + a.type + " " + a.id + " ) foi redefinida, em " + (a.linha + 1));
				}
			}
			
			if(myClass.extendida != null)
			{
				String classPai = myClass.extendida;
				Classes exten = null;
				do
				{
					if(classMap.containsKey(classPai))
					{
						exten = (Classes)classMap.get(classPai);
						
						ss = variavel.entrySet();
						ii = ss.iterator();
						
						while(ii.hasNext())
						{
							Map.Entry entrada = (Map.Entry)ii.next();
							Variables a = (Variables)entrada.getValue();
							
							if(exten.variavel.containsKey(a.id))
							{
								System.out.println("A variavel ( " + a.type + " " + a.id + " ) da Super-Classe: " + exten.id + " foi redefinida, em " + (a.linha + 1));
							}
						}

						classPai = exten.extendida;
					}
					else
						break;			
					
				}while(classPai != null);
			}
		}
		
		if(!arg.isEmpty())
		{
			if(myClass.variavel != null)
			{
				Set ss = arg.entrySet();
				Iterator ii = ss.iterator();
				while(ii.hasNext())
				{
					Map.Entry v = (Map.Entry)ii.next();
					Variables a = (Variables)v.getValue();
					if(myClass.variavel.containsKey(a.id))
					    System.out.println("O argumento ( " + a.type + " " + a.id + " ) foi redefinido, em " + (a.linha + 1));
				}
			}
			
			if(myClass.extendida != null)
			{
				String classPai = myClass.extendida;
				Classes exten = null;
				do
				{
					if(classMap.containsKey(classPai))
					{
						exten = (Classes)classMap.get(classPai);
						
						Set ss = arg.entrySet();
						Iterator ii = ss.iterator();
						
						while(ii.hasNext())
						{
							Map.Entry entrada = (Map.Entry)ii.next();
							Variables a = (Variables)entrada.getValue();
							
							if(exten.variavel.containsKey(a.id))
							{
								System.out.println("O argumento ( " + a.type + " " + a.id + " )) da Super-Classe foi redefinido: " + exten.id + ", em " + (a.linha + 1));
							}
						}

						classPai = exten.extendida;
					}
					else
						break;
					
				}while(classPai != null);
			}
		}		
	}
	
	public void verifTypeExist(Map cl){
		if(variavel != null)
		{
			Set ss = variavel.entrySet();
			Iterator ii = ss.iterator();
			while(ii.hasNext())
			{
				Map.Entry entrada = (Map.Entry)ii.next();
				Variables a = (Variables)entrada.getValue();
				a.verifTypeExist(cl);
			}
		}
		if(!arg.isEmpty())
		{
			Set ss = arg.entrySet();
			Iterator ii = ss.iterator();
			while(ii.hasNext())
			{
				Map.Entry v = (Map.Entry)ii.next();
				Variables a = (Variables)v.getValue();
				a.verifTypeExist(cl);
			}
		}
	}
}
