package com.mailSender;

import javax.swing.JOptionPane;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public final class TextToSpeech {
	private TextToSpeech() {
		
	}
	public static void textToSpeech(String text) {
		System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
    	String voicename="kevin16";
    	Voice voice=VoiceManager.getInstance().getVoice(voicename);
//    	@SuppressWarnings("unused")
//		Voice voicelist[]=VoiceManager.getInstance().getVoices();
    	if(voice!=null) {
    		voice.allocate();
    		@SuppressWarnings("unused")
			boolean status=voice.speak(text);
    		voice.deallocate();
    	}else {
			JOptionPane.showMessageDialog(null, "No voice found !");
    	}
    
	}
}
