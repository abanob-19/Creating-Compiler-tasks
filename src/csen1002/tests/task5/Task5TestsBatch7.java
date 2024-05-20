package csen1002.tests.task5;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.Timeout.ThreadMode;

import csen1002.main.task5.CfgLeftRecElim;

@Timeout(value = 5, unit = TimeUnit.SECONDS, threadMode = ThreadMode.SEPARATE_THREAD)
public class Task5TestsBatch7 {

	@Test
	public void testCfgLeftRecursionElimination1() {
		CfgLeftRecElim cfgLeftRecElim= new CfgLeftRecElim("S;Q;R;D;G#f;i;n;u;y#S/SSy,uSQnQ,SDDD,nD,uRi;Q/RDfD,fDnQR;R/fSQfQ,GRQiQ,QDy,QRRuS;D/fQS,QSf;G/uD,GQy,DiSQ,SDS,GDGyG,RQ");
		cfgLeftRecElim.eliminateLeftRecursion();
		assertEquals("S;Q;R;D;G;S';R';G'#f;i;n;u;y#S/uSQnQS',nDS',uRiS';Q/RDfD,fDnQR;R/fSQfQR',GRQiQR',fDnQRDyR',fDnQRRRuSR';D/fQS,fSQfQR'DfDSf,GRQiQR'DfDSf,fDnQRDyR'DfDSf,fDnQRRRuSR'DfDSf,fDnQRSf;G/uDG',fQSiSQG',fSQfQR'DfDSfiSQG',fDnQRDyR'DfDSfiSQG',fDnQRRRuSR'DfDSfiSQG',fDnQRSfiSQG',uSQnQS'DSG',nDS'DSG',uRiS'DSG',fSQfQR'QG',fDnQRDyR'QG',fDnQRRRuSR'QG';S'/SyS',DDDS',e;R'/DfDDyR',DfDRRuSR',e;G'/QyG',RQiQR'DfDSfiSQG',DGyGG',RQiQR'QG',e", cfgLeftRecElim.toString());
	}

	@Test
	public void testCfgLeftRecursionElimination2() {
		CfgLeftRecElim cfgLeftRecElim= new CfgLeftRecElim("S;Q;G;F;E;C#h;q;s;x;y#S/xSqS,SyQ;Q/CxGQ,xFF,CyC;G/Cx,GEhCs,s,GqCF,QF;F/QGxE,SyG,EqES,FF,SEQ,xG;E/EyS,xFE,EQ,q,Eq;C/yF,Cx,ESyQC,QEyG");
		cfgLeftRecElim.eliminateLeftRecursion();
		assertEquals("S;Q;G;F;E;C;S';G';F';E';C'#h;q;s;x;y#S/xSqSS';Q/CxGQ,xFF,CyC;G/CxG',sG',CxGQFG',xFFFG',CyCFG';F/CxGQGxEF',xFFGxEF',CyCGxEF',xSqSS'yGF',EqESF',xSqSS'EQF',xGF';E/xFEE',qE';C/yFC',xFEE'SyQCC',qE'SyQCC',xFFEyGC';S'/yQS',e;G'/EhCsG',qCFG',e;F'/FF',e;E'/ySE',QE',qE',e;C'/xC',xGQEyGC',yCEyGC',e", cfgLeftRecElim.toString());
	}

	@Test
	public void testCfgLeftRecursionElimination3() {
		CfgLeftRecElim cfgLeftRecElim= new CfgLeftRecElim("S;T;B;J;K;Q#f;g;k#S/SJ,fT,SkS,Bg,f,QQTBQ;T/fQTS,gQ,KTQ;B/gJkSQ,f,SJB,g,kJgBK;J/TgB,BfSg,JJfK,JKfQ,fS,k;K/gSQJ,g,QS,JgTgJ,gJTBT;Q/gQSQ,KfSf,g,SQg");
		cfgLeftRecElim.eliminateLeftRecursion();
		assertEquals("S;T;B;J;K;Q;S';B';J';K';Q'#f;g;k#S/fTS',BgS',fS',QQTBQS';T/fQTS,gQ,KTQ;B/gJkSQB',fB',fTS'JBB',fS'JBB',QQTBQS'JBB',gB',kJgBKB';J/fQTSgBJ',gQgBJ',KTQgBJ',gJkSQB'fSgJ',fB'fSgJ',fTS'JBB'fSgJ',fS'JBB'fSgJ',QQTBQS'JBB'fSgJ',gB'fSgJ',kJgBKB'fSgJ',fSJ',kJ';K/gSQJK',gK',QSK',fQTSgBJ'gTgJK',gQgBJ'gTgJK',gJkSQB'fSgJ'gTgJK',fB'fSgJ'gTgJK',fTS'JBB'fSgJ'gTgJK',fS'JBB'fSgJ'gTgJK',QQTBQS'JBB'fSgJ'gTgJK',gB'fSgJ'gTgJK',kJgBKB'fSgJ'gTgJK',fSJ'gTgJK',kJ'gTgJK',gJTBTK';Q/gQSQQ',gSQJK'fSfQ',gK'fSfQ',fQTSgBJ'gTgJK'fSfQ',gQgBJ'gTgJK'fSfQ',gJkSQB'fSgJ'gTgJK'fSfQ',fB'fSgJ'gTgJK'fSfQ',fTS'JBB'fSgJ'gTgJK'fSfQ',fS'JBB'fSgJ'gTgJK'fSfQ',gB'fSgJ'gTgJK'fSfQ',kJgBKB'fSgJ'gTgJK'fSfQ',fSJ'gTgJK'fSfQ',kJ'gTgJK'fSfQ',gJTBTK'fSfQ',gQ',fTS'QgQ',gJkSQB'gS'QgQ',fB'gS'QgQ',fTS'JBB'gS'QgQ',fS'JBB'gS'QgQ',gB'gS'QgQ',kJgBKB'gS'QgQ',fS'QgQ';S'/JS',kSS',e;B'/gS'JBB',e;J'/JfKJ',KfQJ',e;K'/TQgBJ'gTgJK',e;Q'/SK'fSfQ',QTBQS'JBB'fSgJ'gTgJK'fSfQ',QTBQS'JBB'gS'QgQ',QTBQS'QgQ',e", cfgLeftRecElim.toString());
	}

	@Test
	public void testCfgLeftRecursionElimination4() {
		CfgLeftRecElim cfgLeftRecElim= new CfgLeftRecElim("S;U;P;Z;J;M;I#f;h;r;u;v#S/vJJvS,hZPJ;U/fI,UrSfU,UZrIU,hMZI,rSMuP,ZSIu;P/USMSv,h,ZIU,PvZf;Z/ZJZ,vP,fUUU;J/SUhZU,JrZJZ,rJZv,JvPPZ;M/Pr,SuS,PM,fZSZP;I/uUSP,fUS,PuS,SSv");
		cfgLeftRecElim.eliminateLeftRecursion();
		assertEquals("S;U;P;Z;J;M;I;U';P';Z';J'#f;h;r;u;v#S/vJJvS,hZPJ;U/fIU',hMZIU',rSMuPU',ZSIuU';P/fIU'SMSvP',hMZIU'SMSvP',rSMuPU'SMSvP',ZSIuU'SMSvP',hP',ZIUP';Z/vPZ',fUUUZ';J/vJJvSUhZUJ',hZPJUhZUJ',rJZvJ';M/fIU'SMSvP'r,hMZIU'SMSvP'r,rSMuPU'SMSvP'r,vPZ'SIuU'SMSvP'r,fUUUZ'SIuU'SMSvP'r,hP'r,vPZ'IUP'r,fUUUZ'IUP'r,vJJvSuS,hZPJuS,fIU'SMSvP'M,hMZIU'SMSvP'M,rSMuPU'SMSvP'M,vPZ'SIuU'SMSvP'M,fUUUZ'SIuU'SMSvP'M,hP'M,vPZ'IUP'M,fUUUZ'IUP'M,fZSZP;I/uUSP,fUS,fIU'SMSvP'uS,hMZIU'SMSvP'uS,rSMuPU'SMSvP'uS,vPZ'SIuU'SMSvP'uS,fUUUZ'SIuU'SMSvP'uS,hP'uS,vPZ'IUP'uS,fUUUZ'IUP'uS,vJJvSSv,hZPJSv;U'/rSfUU',ZrIUU',e;P'/vZfP',e;Z'/JZZ',e;J'/rZJZJ',vPPZJ',e", cfgLeftRecElim.toString());
	}

	@Test
	public void testCfgLeftRecursionElimination5() {
		CfgLeftRecElim cfgLeftRecElim= new CfgLeftRecElim("S;U;B;X;T#f;j;u#S/u,j,uTUXj;U/XjB,UBXfX,UuT,SjXf;B/UXXXS,BBTUu,BS,XXUj,BBuXj,UXXBX;X/BfXT,BjUf;T/fTX,UTB");
		cfgLeftRecElim.eliminateLeftRecursion();
		assertEquals("S;U;B;X;T;U';B';X'#f;j;u#S/u,j,uTUXj;U/XjBU',ujXfU',jjXfU',uTUXjjXfU';B/XjBU'XXXSB',ujXfU'XXXSB',jjXfU'XXXSB',uTUXjjXfU'XXXSB',XXUjB',XjBU'XXBXB',ujXfU'XXBXB',jjXfU'XXBXB',uTUXjjXfU'XXBXB';X/ujXfU'XXXSB'fXTX',jjXfU'XXXSB'fXTX',uTUXjjXfU'XXXSB'fXTX',ujXfU'XXBXB'fXTX',jjXfU'XXBXB'fXTX',uTUXjjXfU'XXBXB'fXTX',ujXfU'XXXSB'jUfX',jjXfU'XXXSB'jUfX',uTUXjjXfU'XXXSB'jUfX',ujXfU'XXBXB'jUfX',jjXfU'XXBXB'jUfX',uTUXjjXfU'XXBXB'jUfX';T/fTX,ujXfU'XXXSB'fXTX'jBU'TB,jjXfU'XXXSB'fXTX'jBU'TB,uTUXjjXfU'XXXSB'fXTX'jBU'TB,ujXfU'XXBXB'fXTX'jBU'TB,jjXfU'XXBXB'fXTX'jBU'TB,uTUXjjXfU'XXBXB'fXTX'jBU'TB,ujXfU'XXXSB'jUfX'jBU'TB,jjXfU'XXXSB'jUfX'jBU'TB,uTUXjjXfU'XXXSB'jUfX'jBU'TB,ujXfU'XXBXB'jUfX'jBU'TB,jjXfU'XXBXB'jUfX'jBU'TB,uTUXjjXfU'XXBXB'jUfX'jBU'TB,ujXfU'TB,jjXfU'TB,uTUXjjXfU'TB;U'/BXfXU',uTU',e;B'/BTUuB',SB',BuXjB',e;X'/jBU'XXXSB'fXTX',XUjB'fXTX',jBU'XXBXB'fXTX',jBU'XXXSB'jUfX',XUjB'jUfX',jBU'XXBXB'jUfX',e", cfgLeftRecElim.toString());
	}

	@Test
	public void testCfgLeftRecursionElimination6() {
		CfgLeftRecElim cfgLeftRecElim= new CfgLeftRecElim("S;K;H;F;M;U#g;o;q#S/gKHM,HqU,HUK,oUKF,SqHMo,SFHo;K/gSS,SHH,SqHo,oFK,UgHoK;H/oUg,oM,KUK;F/qKo,FoMH,FFFH,qMS,MUFg,oKH;M/MgSo,gH,oMMMH,g,FqMq,FoS;U/q,HF,qF,MqHH,g");
		cfgLeftRecElim.eliminateLeftRecursion();
		assertEquals("S;K;H;F;M;U;S';H';F';M';U'#g;o;q#S/gKHMS',HqUS',HUKS',oUKFS';K/gSS,gKHMS'HH,HqUS'HH,HUKS'HH,oUKFS'HH,gKHMS'qHo,HqUS'qHo,HUKS'qHo,oUKFS'qHo,oFK,UgHoK;H/oUgH',oMH',gSSUKH',gKHMS'HHUKH',oUKFS'HHUKH',gKHMS'qHoUKH',oUKFS'qHoUKH',oFKUKH',UgHoKUKH';F/qKoF',qMSF',MUFgF',oKHF';M/gHM',oMMMHM',gM',qKoF'qMqM',qMSF'qMqM',oKHF'qMqM',qKoF'oSM',qMSF'oSM',oKHF'oSM';U/qU',oUgH'FU',oMH'FU',gSSUKH'FU',gKHMS'HHUKH'FU',oUKFS'HHUKH'FU',gKHMS'qHoUKH'FU',oUKFS'qHoUKH'FU',oFKUKH'FU',qFU',gHM'qHHU',oMMMHM'qHHU',gM'qHHU',qKoF'qMqM'qHHU',qMSF'qMqM'qHHU',oKHF'qMqM'qHHU',qKoF'oSM'qHHU',qMSF'oSM'qHHU',oKHF'oSM'qHHU',gU';S'/qHMoS',FHoS',e;H'/qUS'HHUKH',UKS'HHUKH',qUS'qHoUKH',UKS'qHoUKH',e;F'/oMHF',FFHF',e;M'/gSoM',UFgF'qMqM',UFgF'oSM',e;U'/gHoKUKH'FU',e", cfgLeftRecElim.toString());
	}

	@Test
	public void testCfgLeftRecursionElimination7() {
		CfgLeftRecElim cfgLeftRecElim= new CfgLeftRecElim("S;Q;M;G;I;R#b;g;o;s;v#S/bG,ISISs,oGv;Q/RbSM,QIo,QM,Ro;M/b,MMgIv;G/vQIbM,bMG,g,oIgGM;I/MMvRv,MI,Qb,IS,SGQsR,IISsS;R/IbGo,bI,SR");
		cfgLeftRecElim.eliminateLeftRecursion();
		assertEquals("S;Q;M;G;I;R;Q';M';I';R'#b;g;o;s;v#S/bG,ISISs,oGv;Q/RbSMQ',RoQ';M/bM';G/vQIbM,bMG,g,oIgGM;I/bM'MvRvI',bM'II',RbSMQ'bI',RoQ'bI',bGGQsRI',oGvGQsRI';R/bM'MvRvI'bGoR',bM'II'bGoR',bGGQsRI'bGoR',oGvGQsRI'bGoR',bIR',bGRR',bM'MvRvI'SISsRR',bM'II'SISsRR',bGGQsRI'SISsRR',oGvGQsRI'SISsRR',oGvRR';Q'/IoQ',MQ',e;M'/MgIvM',e;I'/SI',SISsGQsRI',ISsSI',e;R'/bSMQ'bI'bGoR',oQ'bI'bGoR',bSMQ'bI'SISsRR',oQ'bI'SISsRR',e", cfgLeftRecElim.toString());
	}

	@Test
	public void testCfgLeftRecursionElimination8() {
		CfgLeftRecElim cfgLeftRecElim= new CfgLeftRecElim("S;N;R;B;V;F#a;d;k;n#S/FnV,kSSN,dFNnS,dF,k,n;N/NRk,BBFk,NkS,BF,NR;R/NaSV,NF,NnFd;B/Sd,NdFR;V/NnNS,nSVNF;F/FFBB,VaSV,Vn,BB,FnVFV,nNS");
		cfgLeftRecElim.eliminateLeftRecursion();
		assertEquals("S;N;R;B;V;F;N';B';F'#a;d;k;n#S/FnV,kSSN,dFNnS,dF,k,n;N/BBFkN',BFN';R/BBFkN'aSV,BFN'aSV,BBFkN'F,BFN'F,BBFkN'nFd,BFN'nFd;B/FnVdB',kSSNdB',dFNnSdB',dFdB',kdB',ndB';V/FnVdB'BFkN'nNS,kSSNdB'BFkN'nNS,dFNnSdB'BFkN'nNS,dFdB'BFkN'nNS,kdB'BFkN'nNS,ndB'BFkN'nNS,FnVdB'FN'nNS,kSSNdB'FN'nNS,dFNnSdB'FN'nNS,dFdB'FN'nNS,kdB'FN'nNS,ndB'FN'nNS,nSVNF;F/kSSNdB'BFkN'nNSaSVF',dFNnSdB'BFkN'nNSaSVF',dFdB'BFkN'nNSaSVF',kdB'BFkN'nNSaSVF',ndB'BFkN'nNSaSVF',kSSNdB'FN'nNSaSVF',dFNnSdB'FN'nNSaSVF',dFdB'FN'nNSaSVF',kdB'FN'nNSaSVF',ndB'FN'nNSaSVF',nSVNFaSVF',kSSNdB'BFkN'nNSnF',dFNnSdB'BFkN'nNSnF',dFdB'BFkN'nNSnF',kdB'BFkN'nNSnF',ndB'BFkN'nNSnF',kSSNdB'FN'nNSnF',dFNnSdB'FN'nNSnF',dFdB'FN'nNSnF',kdB'FN'nNSnF',ndB'FN'nNSnF',nSVNFnF',kSSNdB'BF',dFNnSdB'BF',dFdB'BF',kdB'BF',ndB'BF',nNSF';N'/RkN',kSN',RN',e;B'/BFkN'dFRB',FN'dFRB',e;F'/FBBF',nVdB'BFkN'nNSaSVF',nVdB'FN'nNSaSVF',nVdB'BFkN'nNSnF',nVdB'FN'nNSnF',nVdB'BF',nVFVF',e", cfgLeftRecElim.toString());
	}

	@Test
	public void testCfgLeftRecursionElimination9() {
		CfgLeftRecElim cfgLeftRecElim= new CfgLeftRecElim("S;F;L;X;E;T#k;q;w#S/wX,FT,kSXkT,SF,k,ETq;F/FwTXX,FkTL,qTF,EXT,SqF;L/TE,XX,FLk,EwLTF;X/wTEw,EXqX;E/w,LTkT,XTEL;T/Fw,Ek,TL,qLLF,TTEF,qXSq");
		cfgLeftRecElim.eliminateLeftRecursion();
		assertEquals("S;F;L;X;E;T;S';F';E';T'#k;q;w#S/wXS',FTS',kSXkTS',kS',ETqS';F/qTFF',EXTF',wXS'qFF',kSXkTS'qFF',kS'qFF',ETqS'qFF';L/TE,XX,qTFF'Lk,EXTF'Lk,wXS'qFF'Lk,kSXkTS'qFF'Lk,kS'qFF'Lk,ETqS'qFF'Lk,EwLTF;X/wTEw,EXqX;E/wE',TETkTE',wTEwXTkTE',qTFF'LkTkTE',wXS'qFF'LkTkTE',kSXkTS'qFF'LkTkTE',kS'qFF'LkTkTE',wTEwTELE';T/qTFF'wT',wE'XTF'wT',wTEwXTkTE'XTF'wT',qTFF'LkTkTE'XTF'wT',wXS'qFF'LkTkTE'XTF'wT',kSXkTS'qFF'LkTkTE'XTF'wT',kS'qFF'LkTkTE'XTF'wT',wTEwTELE'XTF'wT',wXS'qFF'wT',kSXkTS'qFF'wT',kS'qFF'wT',wE'TqS'qFF'wT',wTEwXTkTE'TqS'qFF'wT',qTFF'LkTkTE'TqS'qFF'wT',wXS'qFF'LkTkTE'TqS'qFF'wT',kSXkTS'qFF'LkTkTE'TqS'qFF'wT',kS'qFF'LkTkTE'TqS'qFF'wT',wTEwTELE'TqS'qFF'wT',wE'kT',wTEwXTkTE'kT',qTFF'LkTkTE'kT',wXS'qFF'LkTkTE'kT',kSXkTS'qFF'LkTkTE'kT',kS'qFF'LkTkTE'kT',wTEwTELE'kT',qLLFT',qXSqT';S'/FS',e;F'/wTXXF',kTLF',TS'qFF',e;E'/XqXXTkTE',XTF'LkTkTE',TqS'qFF'LkTkTE',wLTFTkTE',XqXTELE',e;T'/ETkTE'XTF'wT',ETkTE'TqS'qFF'wT',ETkTE'kT',LT',TEFT',e", cfgLeftRecElim.toString());
	}

	@Test
	public void testCfgLeftRecursionElimination10() {
		CfgLeftRecElim cfgLeftRecElim= new CfgLeftRecElim("S;D;A;P;J#c;h;j;w#S/ADS,ScA,SDjAS,w;D/SwPDS,SJjA,Jc;A/cA,hDSSh,PjJhP,ShDDS,DShAh;P/JDwA,PjDPj,cAjA,cDJhA,cJ,SAD;J/cAP,AAP,PP,wD,JAS,JD");
		cfgLeftRecElim.eliminateLeftRecursion();
		assertEquals("S;D;A;P;J;S';A';P';J'#c;h;j;w#S/ADSS',wS';D/ADSS'wPDS,wS'wPDS,ADSS'JjA,wS'JjA,Jc;A/cAA',hDSShA',PjJhPA',wS'hDDSA',wS'wPDSShAhA',wS'JjAShAhA',JcShAhA';P/JDwAP',cAjAP',cDJhAP',cJP',cAA'DSS'ADP',hDSShA'DSS'ADP',wS'hDDSA'DSS'ADP',wS'wPDSShAhA'DSS'ADP',wS'JjAShAhA'DSS'ADP',JcShAhA'DSS'ADP',wS'ADP';J/cAPJ',cAA'APJ',hDSShA'APJ',cAjAP'jJhPA'APJ',cDJhAP'jJhPA'APJ',cJP'jJhPA'APJ',cAA'DSS'ADP'jJhPA'APJ',hDSShA'DSS'ADP'jJhPA'APJ',wS'hDDSA'DSS'ADP'jJhPA'APJ',wS'wPDSShAhA'DSS'ADP'jJhPA'APJ',wS'JjAShAhA'DSS'ADP'jJhPA'APJ',wS'ADP'jJhPA'APJ',wS'hDDSA'APJ',wS'wPDSShAhA'APJ',wS'JjAShAhA'APJ',cAjAP'PJ',cDJhAP'PJ',cJP'PJ',cAA'DSS'ADP'PJ',hDSShA'DSS'ADP'PJ',wS'hDDSA'DSS'ADP'PJ',wS'wPDSShAhA'DSS'ADP'PJ',wS'JjAShAhA'DSS'ADP'PJ',wS'ADP'PJ',wDJ';S'/cAS',DjASS',e;A'/DSS'hDDSA',DSS'wPDSShAhA',DSS'JjAShAhA',e;P'/jDPjP',jJhPA'DSS'ADP',e;J'/DwAP'jJhPA'APJ',cShAhA'DSS'ADP'jJhPA'APJ',cShAhA'APJ',DwAP'PJ',cShAhA'DSS'ADP'PJ',ASJ',DJ',e", cfgLeftRecElim.toString());
	}

}