package csen1002.tests.task5;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.Timeout.ThreadMode;

import csen1002.main.task5.CfgLeftRecElim;

@Timeout(value = 5, unit = TimeUnit.SECONDS, threadMode = ThreadMode.SEPARATE_THREAD)
public class Task5TestsBatch6 {

	@Test
	public void testCfgLeftRecursionElimination1() {
		CfgLeftRecElim cfgLeftRecElim= new CfgLeftRecElim("S;J;N;V;B;O#f;x;z#S/Nz,OB,SxSO,zSONf;J/SSzO,SSOx,Jz,VzNf,x,JJzO;N/JfO,fBz;V/NJz,Vz;B/BBxBx,zBJ,zSNx,zJz,OxVz,BfSf;O/Bf,BxNV");
		cfgLeftRecElim.eliminateLeftRecursion();
		assertEquals("S;J;N;V;B;O;S';J';N';V';B';O'#f;x;z#S/NzS',OBS',zSONfS';J/NzS'SzOJ',OBS'SzOJ',zSONfS'SzOJ',NzS'SOxJ',OBS'SOxJ',zSONfS'SOxJ',VzNfJ',xJ';N/OBS'SzOJ'fON',zSONfS'SzOJ'fON',OBS'SOxJ'fON',zSONfS'SOxJ'fON',VzNfJ'fON',xJ'fON',fBzN';V/OBS'SzOJ'fON'JzV',zSONfS'SzOJ'fON'JzV',OBS'SOxJ'fON'JzV',zSONfS'SOxJ'fON'JzV',xJ'fON'JzV',fBzN'JzV';B/zBJB',zSNxB',zJzB',OxVzB';O/zBJB'fO',zSNxB'fO',zJzB'fO',zBJB'xNVO',zSNxB'xNVO',zJzB'xNVO';S'/xSOS',e;J'/zJ',JzOJ',e;N'/zS'SzOJ'fON',zS'SOxJ'fON',e;V'/zNfJ'fON'JzV',zV',e;B'/BxBxB',fSfB',e;O'/xVzB'fO',xVzB'xNVO',e", cfgLeftRecElim.toString());
	}

	@Test
	public void testCfgLeftRecursionElimination2() {
		CfgLeftRecElim cfgLeftRecElim= new CfgLeftRecElim("S;E;G;O;K;Y;X#b;j;m;u;y#S/GjKb,yYmYX;E/Eb,Ey,j,yX,YbG,mSXu;G/GyGOG,bEjE,GYm,GmYGy,uXyXy;O/ySX,SyKXu,y;K/y,u,YY,mGyO;Y/Gb,KXjGS,bEu,Sm,SEEm,b;X/j,bYm,XGGG,mEX,Sy,SYXOm");
		cfgLeftRecElim.eliminateLeftRecursion();
		assertEquals("S;E;G;O;K;Y;X;E';G';Y';X'#b;j;m;u;y#S/GjKb,yYmYX;E/jE',yXE',YbGE',mSXuE';G/bEjEG',uXyXyG';O/ySX,bEjEG'jKbyKXu,uXyXyG'jKbyKXu,yYmYXyKXu,y;K/y,u,YY,mGyO;Y/bEjEG'bY',uXyXyG'bY',yXjGSY',uXjGSY',mGyOXjGSY',bEuY',bEjEG'jKbmY',uXyXyG'jKbmY',yYmYXmY',bEjEG'jKbEEmY',uXyXyG'jKbEEmY',yYmYXEEmY',bY';X/jX',bYmX',mEXX',bEjEG'jKbyX',uXyXyG'jKbyX',yYmYXyX',bEjEG'jKbYXOmX',uXyXyG'jKbYXOmX',yYmYXYXOmX';E'/bE',yE',e;G'/yGOGG',YmG',mYGyG',e;Y'/YXjGSY',e;X'/GGGX',e", cfgLeftRecElim.toString());
	}

	@Test
	public void testCfgLeftRecursionElimination3() {
		CfgLeftRecElim cfgLeftRecElim= new CfgLeftRecElim("S;L;U;F;J#c;f;l;o;u#S/SoU,SoUFc,FlFFS,fSFLL,c;L/oUF,c,Ff;U/u,Sc,ULc,UJlJl,LoJ,UUU;F/Sl,USU,oS,FFLJU,lJ;J/cS,UULlF,o,JSfJ,lUUSc");
		cfgLeftRecElim.eliminateLeftRecursion();
		assertEquals("S;L;U;F;J;S';U';F';J'#c;f;l;o;u#S/FlFFSS',fSFLLS',cS';L/oUF,c,Ff;U/uU',FlFFSS'cU',fSFLLS'cU',cS'cU',oUFoJU',coJU',FfoJU';F/fSFLLS'lF',cS'lF',uU'SUF',fSFLLS'cU'SUF',cS'cU'SUF',oUFoJU'SUF',coJU'SUF',oSF',lJF';J/cSJ',uU'ULlFJ',fSFLLS'lF'lFFSS'cU'ULlFJ',cS'lF'lFFSS'cU'ULlFJ',uU'SUF'lFFSS'cU'ULlFJ',fSFLLS'cU'SUF'lFFSS'cU'ULlFJ',cS'cU'SUF'lFFSS'cU'ULlFJ',oUFoJU'SUF'lFFSS'cU'ULlFJ',coJU'SUF'lFFSS'cU'ULlFJ',oSF'lFFSS'cU'ULlFJ',lJF'lFFSS'cU'ULlFJ',fSFLLS'cU'ULlFJ',cS'cU'ULlFJ',oUFoJU'ULlFJ',coJU'ULlFJ',fSFLLS'lF'foJU'ULlFJ',cS'lF'foJU'ULlFJ',uU'SUF'foJU'ULlFJ',fSFLLS'cU'SUF'foJU'ULlFJ',cS'cU'SUF'foJU'ULlFJ',oUFoJU'SUF'foJU'ULlFJ',coJU'SUF'foJU'ULlFJ',oSF'foJU'ULlFJ',lJF'foJU'ULlFJ',oJ',lUUScJ';S'/oUS',oUFcS',e;U'/LcU',JlJlU',UUU',e;F'/lFFSS'lF',lFFSS'cU'SUF',foJU'SUF',FLJUF',e;J'/SfJJ',e", cfgLeftRecElim.toString());
	}

	@Test
	public void testCfgLeftRecursionElimination4() {
		CfgLeftRecElim cfgLeftRecElim= new CfgLeftRecElim("S;C;P;K;O#k;q;s#S/qOC,qPPk;C/PsSk,CSCs,CkKP,sKPsO;P/CqOsC,SS,kP,PKqKK,SqSsS,OkSk;K/PqP,s,KK,PPCOk;O/PkP,OsCs,CqSs,SCsO,OK");
		cfgLeftRecElim.eliminateLeftRecursion();
		assertEquals("S;C;P;K;O;C';P';K';O'#k;q;s#S/qOC,qPPk;C/PsSkC',sKPsOC';P/sKPsOC'qOsCP',qOCSP',qPPkSP',kPP',qOCqSsSP',qPPkqSsSP',OkSkP';K/sKPsOC'qOsCP'qPK',qOCSP'qPK',qPPkSP'qPK',kPP'qPK',qOCqSsSP'qPK',qPPkqSsSP'qPK',OkSkP'qPK',sK',sKPsOC'qOsCP'PCOkK',qOCSP'PCOkK',qPPkSP'PCOkK',kPP'PCOkK',qOCqSsSP'PCOkK',qPPkqSsSP'PCOkK',OkSkP'PCOkK';O/sKPsOC'qOsCP'kPO',qOCSP'kPO',qPPkSP'kPO',kPP'kPO',qOCqSsSP'kPO',qPPkqSsSP'kPO',sKPsOC'qOsCP'sSkC'qSsO',qOCSP'sSkC'qSsO',qPPkSP'sSkC'qSsO',kPP'sSkC'qSsO',qOCqSsSP'sSkC'qSsO',qPPkqSsSP'sSkC'qSsO',sKPsOC'qSsO',qOCCsOO',qPPkCsOO';C'/SCsC',kKPC',e;P'/sSkC'qOsCP',KqKKP',e;K'/KK',e;O'/kSkP'kPO',sCsO',kSkP'sSkC'qSsO',KO',e", cfgLeftRecElim.toString());
	}

	@Test
	public void testCfgLeftRecursionElimination5() {
		CfgLeftRecElim cfgLeftRecElim= new CfgLeftRecElim("S;U;C;I;O#c;j;r;s;v#S/vSjIO,IOcC,rUsS;U/cS,OSOr,ICSSC;C/OUUOI,Uj,cO,CjOjO,CvUvI;I/UvC,SUCUj;O/SIsC,OcSU,OSC,UIUSC,OUCj");
		cfgLeftRecElim.eliminateLeftRecursion();
		assertEquals("S;U;C;I;O;C';I';O'#c;j;r;s;v#S/vSjIO,IOcC,rUsS;U/cS,OSOr,ICSSC;C/OUUOIC',cSjC',OSOrjC',ICSSCjC',cOC';I/cSvCI',OSOrvCI',vSjIOUCUjI',rUsSUCUjI';O/vSjIOIsCO',cSvCI'OcCIsCO',vSjIOUCUjI'OcCIsCO',rUsSUCUjI'OcCIsCO',rUsSIsCO',cSIUSCO',cSvCI'CSSCIUSCO',vSjIOUCUjI'CSSCIUSCO',rUsSUCUjI'CSSCIUSCO';C'/jOjOC',vUvIC',e;I'/CSSCvCI',OcCUCUjI',e;O'/SOrvCI'OcCIsCO',cSUO',SCO',SOrIUSCO',SOrvCI'CSSCIUSCO',UCjO',e", cfgLeftRecElim.toString());
	}

	@Test
	public void testCfgLeftRecursionElimination6() {
		CfgLeftRecElim cfgLeftRecElim= new CfgLeftRecElim("S;Z;I;W;D#b;q;u;v;w#S/IbIv,uI,vS;Z/uSwDW,IZbS,uSI,SIZS;I/wDvI,WbWqI,Dv,uW;W/WSZD,SZWDu,Wq,wIII,SS;D/DDDS,Ww,IqZbZ,DZD,IWS,uWWb");
		cfgLeftRecElim.eliminateLeftRecursion();
		assertEquals("S;Z;I;W;D;W';D'#b;q;u;v;w#S/IbIv,uI,vS;Z/uSwDW,IZbS,uSI,IbIvIZS,uIIZS,vSIZS;I/wDvI,WbWqI,Dv,uW;W/wDvIbIvZWDuW',DvbIvZWDuW',uWbIvZWDuW',uIZWDuW',vSZWDuW',wIIIW',wDvIbIvSW',DvbIvSW',uWbIvSW',uISW',vSSW';D/wDvIbIvZWDuW'wD',uWbIvZWDuW'wD',uIZWDuW'wD',vSZWDuW'wD',wIIIW'wD',wDvIbIvSW'wD',uWbIvSW'wD',uISW'wD',vSSW'wD',wDvIqZbZD',wDvIbIvZWDuW'bWqIqZbZD',uWbIvZWDuW'bWqIqZbZD',uIZWDuW'bWqIqZbZD',vSZWDuW'bWqIqZbZD',wIIIW'bWqIqZbZD',wDvIbIvSW'bWqIqZbZD',uWbIvSW'bWqIqZbZD',uISW'bWqIqZbZD',vSSW'bWqIqZbZD',uWqZbZD',wDvIWSD',wDvIbIvZWDuW'bWqIWSD',uWbIvZWDuW'bWqIWSD',uIZWDuW'bWqIWSD',vSZWDuW'bWqIWSD',wIIIW'bWqIWSD',wDvIbIvSW'bWqIWSD',uWbIvSW'bWqIWSD',uISW'bWqIWSD',vSSW'bWqIWSD',uWWSD',uWWbD';W'/SZDW',bWqIbIvZWDuW',qW',bWqIbIvSW',e;D'/DDSD',vbIvZWDuW'wD',vbIvSW'wD',vbIvZWDuW'bWqIqZbZD',vbIvSW'bWqIqZbZD',vqZbZD',ZDD',vbIvZWDuW'bWqIWSD',vbIvSW'bWqIWSD',vWSD',e", cfgLeftRecElim.toString());
	}

	@Test
	public void testCfgLeftRecursionElimination7() {
		CfgLeftRecElim cfgLeftRecElim= new CfgLeftRecElim("S;T;E;W;F#a;h;l;n#S/SaS,SE,a,TFWFE,hTTS;T/EhSSl,Fh,hTWW;E/EFaEF,FTlWn,EFlF,ShEET;W/hST,hET,nTlT,TSF,TESWW,lWF;F/EaT,SFn");
		cfgLeftRecElim.eliminateLeftRecursion();
		assertEquals("S;T;E;W;F;S';E';F'#a;h;l;n#S/aS',TFWFES',hTTSS';T/EhSSl,Fh,hTWW;E/FTlWnE',aS'hEETE',FhFWFES'hEETE',hTWWFWFES'hEETE',hTTSS'hEETE';W/hST,hET,nTlT,FTlWnE'hSSlSF,aS'hEETE'hSSlSF,FhFWFES'hEETE'hSSlSF,hTWWFWFES'hEETE'hSSlSF,hTTSS'hEETE'hSSlSF,FhSF,hTWWSF,FTlWnE'hSSlESWW,aS'hEETE'hSSlESWW,FhFWFES'hEETE'hSSlESWW,hTWWFWFES'hEETE'hSSlESWW,hTTSS'hEETE'hSSlESWW,FhESWW,hTWWESWW,lWF;F/aS'hEETE'aTF',hTWWFWFES'hEETE'aTF',hTTSS'hEETE'aTF',aS'FnF',aS'hEETE'hSSlFWFES'FnF',hTWWFWFES'hEETE'hSSlFWFES'FnF',hTTSS'hEETE'hSSlFWFES'FnF',hTWWFWFES'FnF',hTTSS'FnF';S'/aSS',ES',e;E'/FaEFE',FlFE',hSSlFWFES'hEETE',e;F'/TlWnE'aTF',hFWFES'hEETE'aTF',TlWnE'hSSlFWFES'FnF',hFWFES'hEETE'hSSlFWFES'FnF',hFWFES'FnF',e", cfgLeftRecElim.toString());
	}

	@Test
	public void testCfgLeftRecursionElimination8() {
		CfgLeftRecElim cfgLeftRecElim= new CfgLeftRecElim("S;A;O;Q;H#n;v;y;z#S/v,zQ,QAQA,nQ;A/AHy,nQHAy,AQvOA;O/SSS,SyQ,z;Q/AS,y,SSnO;H/Hv,AH,HH");
		cfgLeftRecElim.eliminateLeftRecursion();
		assertEquals("S;A;O;Q;H;A';Q';H'#n;v;y;z#S/v,zQ,QAQA,nQ;A/nQHAyA';O/vSS,zQSS,QAQASS,nQSS,vyQ,zQyQ,QAQAyQ,nQyQ,z;Q/nQHAyA'SQ',yQ',vSnOQ',zQSnOQ',nQSnOQ';H/nQHAyA'HH';A'/HyA',QvOAA',e;Q'/AQASnOQ',e;H'/vH',HH',e", cfgLeftRecElim.toString());
	}

	@Test
	public void testCfgLeftRecursionElimination9() {
		CfgLeftRecElim cfgLeftRecElim= new CfgLeftRecElim("S;J;F;W;D#a;f;i;r;y#S/Fy,SfSyD;J/rFFSr,JFi,Fa,SD,JyDJa;F/DJ,FSSJS,SFD,yJFf,JiSSr,r;W/SWWSW,WJDaW,rJ,FWrJi,iW,WSSJ;D/r,iWi,fWFf,DfFy,fSWyS");
		cfgLeftRecElim.eliminateLeftRecursion();
		assertEquals("S;J;F;W;D;S';J';F';W';D'#a;f;i;r;y#S/FyS';J/rFFSrJ',FaJ',FyS'DJ';F/DJF',yJFfF',rFFSrJ'iSSrF',rF';W/DJF'yS'WWSWW',yJFfF'yS'WWSWW',rFFSrJ'iSSrF'yS'WWSWW',rF'yS'WWSWW',rJW',DJF'WrJiW',yJFfF'WrJiW',rFFSrJ'iSSrF'WrJiW',rF'WrJiW',iWW';D/rD',iWiD',fWFfD',fSWySD';S'/fSyDS',e;J'/FiJ',yDJaJ',e;F'/SSJSF',yS'FDF',aJ'iSSrF',yS'DJ'iSSrF',e;W'/JDaWW',SSJW',e;D'/fFyD',e", cfgLeftRecElim.toString());
	}

	@Test
	public void testCfgLeftRecursionElimination10() {
		CfgLeftRecElim cfgLeftRecElim= new CfgLeftRecElim("S;X;F;R;N;Q;V#h;n;o;r;x#S/XSrQ,nVVNQ;X/XxFN,XnF,XNo,NSx;F/NVQX,FoQFX,FSNn,VX,QVV;R/xQ,XN;N/n,xV,hFR;Q/VX,oR,XoQ,hV,FNr;V/NXn,QRQ");
		cfgLeftRecElim.eliminateLeftRecursion();
		assertEquals("S;X;F;R;N;Q;V;X';F';Q';V'#h;n;o;r;x#S/XSrQ,nVVNQ;X/NSxX';F/NVQXF',VXF',QVVF';R/xQ,NSxX'N;N/n,xV,hFR;Q/VXQ',oRQ',nSxX'oQQ',xVSxX'oQQ',hFRSxX'oQQ',hVQ',nVQXF'NrQ',xVVQXF'NrQ',hFRVQXF'NrQ',VXF'NrQ';V/nXnV',xVXnV',hFRXnV',oRQ'RQV',nSxX'oQQ'RQV',xVSxX'oQQ'RQV',hFRSxX'oQQ'RQV',hVQ'RQV',nVQXF'NrQ'RQV',xVVQXF'NrQ'RQV',hFRVQXF'NrQ'RQV';X'/xFNX',nFX',NoX',e;F'/oQFXF',SNnF',e;Q'/VVF'NrQ',e;V'/XQ'RQV',XF'NrQ'RQV',e", cfgLeftRecElim.toString());
	}

}