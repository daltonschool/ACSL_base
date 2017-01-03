package org.dalton.acsl2.string15;
import java.util.*;
public class ACSL2_STRING15_C17DW {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while(true){
			String x = s.nextLine();
			char[] a = x.toCharArray();
			int p1=0;
			int p2=0;
			int ipd=-1;
			int l = 0;
			int xd = 0;
			for(int i = 0; i<a.length ; i++){
				if(a[i]=='.') ipd = i;
				if(a[i]==','){
					if(p1==0) p1=i+2;
					else p2=i+2;}}	
			char[] t = new char[p1-2];
			char[] cl = new char[p2-p1];
			char[] cd = new char[a.length-p2];
			for(int i = 0; i<p1-2 ; i++) t[i] = a[i];
			for(int i = p1; i<p2-2 ; i++) cl[i-p1] = a[i];
			for(int i = p2; i<a.length ; i++) cd[i-p2] = a[i];
			for(int i = cl.length-3 ; i >= 0 ; i--) l += (cl[i]-48)*Math.pow(10, cl.length - (i+3));
			for(int i = cd.length-1 ; i >= 0 ; i--) xd += (cd[i]-48)*Math.pow(10, cd.length - (i+1));
			if(l!=0&&xd>0){
				char[] o = new char[l];
				for(int i = 0 ; i < l ; i++) o[i] = '#';
				int op = l-xd-1;
				if(xd!=0) o[op] = '.';
				int indec = t.length-(ipd+1);
				if(ipd<=op){
					int k = 0;
					for(int i = 0; i <= op ; i++) if(op-ipd<=i) o[i] = t[k++];
					for(int i = op+1 ; i<l; i++) o[i]= '0';
					if(indec<xd) for(int i = op ; i<t.length; i++) o[i+1]= t[i-op+ipd+1];
					else if(indec==xd)for(int i = op ; i<=t.length; i++)o[i+1]= t[i-op+ipd+1];
					else{
						for(int i = op+1 ; i<l; i++){
							if(i==l-1&&t[i-op+ipd+1]>'4') o[i]= (char) ((int) t[xd+ipd] + 1);
							else o[i]= t[i-op+ipd];}}}
				System.out.println(o);}
			else if(l!=0){
				char[] o = new char[l];
				for(int i = 0 ; i < l ; i++) o[i] = '#';
				if(t.length<=l){
					int k = 0;
					for(int i = l-t.length; i < l ; i++) o[i] = t[k++];
				System.out.println(o);}}
			else{System.out.println();}}}}