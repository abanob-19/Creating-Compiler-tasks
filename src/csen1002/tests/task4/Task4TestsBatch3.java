package csen1002.tests.task4;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.Timeout.ThreadMode;

import csen1002.main.task4.CfgEpsUnitElim;

@Timeout(value = 5, unit = TimeUnit.SECONDS, threadMode = ThreadMode.SEPARATE_THREAD)
public class Task4TestsBatch3 {

	@Test
	public void testCfgEpsilonRuleElimination1() {
		CfgEpsUnitElim cfgEpsUnitElim= new CfgEpsUnitElim("S;L;B;X;Y;D;Z#a;k;o;p;v#S/X,Y,YLSL,oXvS;L/kYZL,pDa;B/D,L,e,kLa,oBSL;X/L,S,oBaBL;Y/LS,ZZp,oS;D/DSB,LoBB,aBvD,aL,e;Z/LL,LLB,S,v");
		cfgEpsUnitElim.eliminateEpsilonRules();
		assertEquals("S;L;B;X;Y;D;Z#a;k;o;p;v#S/X,Y,YLSL,oXvS;L/kYZL,pDa,pa;B/D,L,kLa,oBSL,oSL;X/L,S,oBaBL,oBaL,oaBL,oaL;Y/LS,ZZp,oS;D/DS,DSB,Lo,LoB,LoBB,S,SB,aBv,aBvD,aL,av,avD;Z/LL,LLB,S,v", cfgEpsUnitElim.toString());
	}

	@Test
	public void testCfgEpsilonRuleElimination2() {
		CfgEpsUnitElim cfgEpsUnitElim= new CfgEpsUnitElim("S;P;M;V;T;C;I#k;x;z#S/SV,TxPMI;P/M,P,PIzC,S,SCk,SkIVx,T,e;M/VxIVT,VxT,e,k;V/V,e,kMMkC,zIVxT,zPz;T/VPTkP,VzMSC,xPICI;C/M,SkP,SxIC,zVV;I/C,VTSz,kCT,z");
		cfgEpsUnitElim.eliminateEpsilonRules();
		assertEquals("S;P;M;V;T;C;I#k;x;z#S/S,SV,Tx,TxI,TxM,TxMI,TxP,TxPI,TxPM,TxPMI;P/Iz,IzC,M,P,PIz,PIzC,Pz,PzC,S,SCk,Sk,SkIVx,SkIx,SkVx,Skx,T,z,zC;M/VxIT,VxIVT,VxT,VxVT,k,xIT,xIVT,xT,xVT;V/V,kMMk,kMMkC,kMk,kMkC,kk,kkC,zIVxT,zIxT,zPz,zVxT,zxT,zz;T/PTk,PTkP,Tk,TkP,VPTk,VPTkP,VTk,VTkP,VzMS,VzMSC,VzS,VzSC,x,xC,xCI,xI,xIC,xICI,xII,xP,xPC,xPCI,xPI,xPIC,xPICI,xPII,zMS,zMSC,zS,zSC;C/M,Sk,SkP,Sx,SxC,SxI,SxIC,z,zV,zVV;I/C,TSz,VTSz,kCT,kT,z", cfgEpsUnitElim.toString());
	}

	@Test
	public void testCfgEpsilonRuleElimination3() {
		CfgEpsUnitElim cfgEpsUnitElim= new CfgEpsUnitElim("S;R;V;P;G#d;h;r;t#S/G,S,dRPtS,hRt;R/R,S,SdGRR,hShVV,hV;V/GGt,PP,d,e;P/PGrPr,StGr,e;G/GVGS,RhGPh,S,VRVr");
		cfgEpsUnitElim.eliminateEpsilonRules();
		assertEquals("S;R;V;P;G#d;h;r;t#S/G,S,dRPtS,dRtS,hRt;R/R,S,SdGRR,h,hSh,hShV,hShVV,hV;V/GGt,P,PP,d;P/GrPr,Grr,PGrPr,PGrr,StGr;G/GGS,GVGS,RVr,RhGPh,RhGh,Rr,S,VRVr,VRr", cfgEpsUnitElim.toString());
	}

	@Test
	public void testCfgUnitRuleElimination1() {
		CfgEpsUnitElim cfgEpsUnitElim= new CfgEpsUnitElim("S;Y;E;U;V#b;g;t;v#S/SYtE,U,Y,bUVE;Y/VUUYE,Y,YUUgS,t;E/U,bU;U/E,S,bYU,tVEt;V/SU,UEVgV,Vg,vY");
		cfgEpsUnitElim.eliminateUnitRules();
		assertEquals("S;Y;E;U;V#b;g;t;v#S/SYtE,VUUYE,YUUgS,bU,bUVE,bYU,t,tVEt;Y/VUUYE,YUUgS,t;E/SYtE,VUUYE,YUUgS,bU,bUVE,bYU,t,tVEt;U/SYtE,VUUYE,YUUgS,bU,bUVE,bYU,t,tVEt;V/SU,UEVgV,Vg,vY", cfgEpsUnitElim.toString());
	}

	@Test
	public void testCfgUnitRuleElimination2() {
		CfgEpsUnitElim cfgEpsUnitElim= new CfgEpsUnitElim("S;Z;A;M;N#p;t;u#S/A,ZNMZS,tAMM,uZtS;Z/M,pMSAZ,tZ;A/AApZ,N,NAMMA,tZtNZ;M/M,MtS,SpMZS,Z;N/AM,Ap,St");
		cfgEpsUnitElim.eliminateUnitRules();
		assertEquals("S;Z;A;M;N#p;t;u#S/AApZ,AM,Ap,NAMMA,St,ZNMZS,tAMM,tZtNZ,uZtS;Z/MtS,SpMZS,pMSAZ,tZ;A/AApZ,AM,Ap,NAMMA,St,tZtNZ;M/MtS,SpMZS,pMSAZ,tZ;N/AM,Ap,St", cfgEpsUnitElim.toString());
	}

	@Test
	public void testCfgUnitRuleElimination3() {
		CfgEpsUnitElim cfgEpsUnitElim= new CfgEpsUnitElim("S;O;T;Z;A;F#j;n;p;w#S/A,T,nS,pSjA;O/O,OTZ,Z,j,nOwF;T/F,S,jZS;Z/nOFS,nS;A/AT,AZ,SF,Z;F/ApASj,TpZ,ZSZSF,ZpF");
		cfgEpsUnitElim.eliminateUnitRules();
		assertEquals("S;O;T;Z;A;F#j;n;p;w#S/AT,AZ,ApASj,SF,TpZ,ZSZSF,ZpF,jZS,nOFS,nS,pSjA;O/OTZ,j,nOFS,nOwF,nS;T/AT,AZ,ApASj,SF,TpZ,ZSZSF,ZpF,jZS,nOFS,nS,pSjA;Z/nOFS,nS;A/AT,AZ,SF,nOFS,nS;F/ApASj,TpZ,ZSZSF,ZpF", cfgEpsUnitElim.toString());
	}

	@Test
	public void testCfgEpsilonUnitRuleElimination1() {
		CfgEpsUnitElim cfgEpsUnitElim= new CfgEpsUnitElim("S;Y;E;L;O;W;G#a;c;m;r;w#S/cW,mYc;Y/E,ScSY,WSc,Y,e;E/O,SY,mOrL,rL;L/cLmE,mLY,mSmGO;O/EESS,S,Y,mEc,mY;W/SO,Y,e,rG,w;G/OYS,c,cEa,mE");
		cfgEpsUnitElim.eliminateEpsilonRules();
		cfgEpsUnitElim.eliminateUnitRules();
		assertEquals("S;Y;E;L;O;W;G#a;c;m;r;w#S/c,cW,mYc,mc;Y/EESS,ESS,SS,SY,Sc,ScS,ScSY,WSc,c,cW,m,mEc,mOrL,mY,mYc,mc,mrL,rL;E/EESS,ESS,SS,SY,Sc,ScS,ScSY,WSc,c,cW,m,mEc,mOrL,mY,mYc,mc,mrL,rL;L/cLm,cLmE,mL,mLY,mSmG,mSmGO;O/EESS,ESS,SS,SY,Sc,ScS,ScSY,WSc,c,cW,m,mEc,mOrL,mY,mYc,mc,mrL,rL;W/EESS,ESS,SO,SS,SY,Sc,ScS,ScSY,WSc,c,cW,m,mEc,mOrL,mY,mYc,mc,mrL,rG,rL,w;G/OS,OYS,YS,c,cEa,cW,ca,m,mE,mYc,mc", cfgEpsUnitElim.toString());
	}

	@Test
	public void testCfgEpsilonUnitRuleElimination2() {
		CfgEpsUnitElim cfgEpsUnitElim= new CfgEpsUnitElim("S;A;V;D;C;I#h;m;q;r;z#S/C,D,rA;A/ACAC,ASCm,C,D,e,qSzCh;V/D,DqS,S,e,rD;D/AAD,CrAV,hS,r;C/I,qAVr,rChCr,zIV;I/ISVm,hSSm");
		cfgEpsUnitElim.eliminateEpsilonRules();
		cfgEpsUnitElim.eliminateUnitRules();
		assertEquals("S;A;V;D;C;I#h;m;q;r;z#S/AAD,AD,Cr,CrA,CrAV,CrV,ISVm,ISm,hS,hSSm,qAVr,qAr,qVr,qr,r,rA,rChCr,zI,zIV;A/AAD,ACAC,ACC,AD,ASCm,CAC,CC,Cr,CrA,CrAV,CrV,ISVm,ISm,SCm,hS,hSSm,qAVr,qAr,qSzCh,qVr,qr,r,rChCr,zI,zIV;V/AAD,AD,Cr,CrA,CrAV,CrV,DqS,ISVm,ISm,hS,hSSm,qAVr,qAr,qVr,qr,r,rA,rChCr,rD,zI,zIV;D/AAD,AD,Cr,CrA,CrAV,CrV,hS,r;C/ISVm,ISm,hSSm,qAVr,qAr,qVr,qr,rChCr,zI,zIV;I/ISVm,ISm,hSSm", cfgEpsUnitElim.toString());
	}

	@Test
	public void testCfgEpsilonUnitRuleElimination3() {
		CfgEpsUnitElim cfgEpsUnitElim= new CfgEpsUnitElim("S;L;G;I;W;P;A#b;c;l;v;x#S/S,lA,lAAIL;L/L,PGl,S,bG,bW,e,vLvW;G/AxPWP,I,PAI,W,WAcP,e;I/LSPI,SSI,c;W/I,IlPc,W,bA,cG,xWx;P/PPAA,PbS,e,x;A/AA,P,W,v");
		cfgEpsUnitElim.eliminateEpsilonRules();
		cfgEpsUnitElim.eliminateUnitRules();
		assertEquals("S;L;G;I;W;P;A#b;c;l;v;x#S/l,lA,lAAI,lAAIL,lAI,lAIL,lI,lIL;L/Gl,PGl,Pl,b,bG,bW,l,lA,lAAI,lAAIL,lAI,lAIL,lI,lIL,vLvW,vvW;G/AI,AxPW,AxPWP,AxW,AxWP,IlPc,Ilc,LSI,LSPI,PAI,PI,SI,SPI,SSI,WAc,WAcP,Wc,WcP,b,bA,c,cG,xPW,xPWP,xW,xWP,xWx;I/LSI,LSPI,SI,SPI,SSI,c;W/IlPc,Ilc,LSI,LSPI,SI,SPI,SSI,b,bA,c,cG,xWx;P/AA,IlPc,Ilc,LSI,LSPI,PA,PAA,PP,PPA,PPAA,PbS,SI,SPI,SSI,b,bA,bS,c,cG,v,x,xWx;A/AA,IlPc,Ilc,LSI,LSPI,PA,PAA,PP,PPA,PPAA,PbS,SI,SPI,SSI,b,bA,bS,c,cG,v,x,xWx", cfgEpsUnitElim.toString());
	}

	@Test
	public void testCfgEpsilonUnitRuleElimination4() {
		CfgEpsUnitElim cfgEpsUnitElim= new CfgEpsUnitElim("S;B;Y;O;R;N;I#i;j;n;z#S/BiYN,YNRi;B/B,O,n,zS;Y/OzSn,Rz,iY;O/SiBB,e,jS;R/NSi,Y,e,i,iSnS,zYnS;N/B,IYISO,R,S,e,iSn,jNzSR;I/BBIR,jBOYS");
		cfgEpsUnitElim.eliminateEpsilonRules();
		cfgEpsUnitElim.eliminateUnitRules();
		assertEquals("S;B;Y;O;R;N;I#i;j;n;z#S/BiY,BiYN,YNRi,YNi,YRi,Yi,iY,iYN;B/Si,SiB,SiBB,jS,n,zS;Y/OzSn,Rz,iY,z,zSn;O/Si,SiB,SiBB,jS;R/NSi,OzSn,Rz,Si,i,iSnS,iY,z,zSn,zYnS;N/BiY,BiYN,IYIS,IYISO,NSi,OzSn,Rz,Si,SiB,SiBB,YNRi,YNi,YRi,Yi,i,iSn,iSnS,iY,iYN,jNzS,jNzSR,jS,jzS,jzSR,n,z,zS,zSn,zYnS;I/BBI,BBIR,BI,BIR,IR,jBOYS,jBYS,jOYS,jYS", cfgEpsUnitElim.toString());
	}

}