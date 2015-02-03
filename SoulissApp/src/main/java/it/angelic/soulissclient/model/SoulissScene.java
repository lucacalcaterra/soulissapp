package it.angelic.soulissclient.model;

import android.util.Log;

import it.angelic.soulissclient.Constants;
import it.angelic.soulissclient.R;

import java.io.Serializable;
import java.util.ArrayList;

public class SoulissScene implements Serializable, ISoulissObject, ISoulissExecutable {


	private static final long serialVersionUID = 375896210748961219L;
	private ArrayList<SoulissCommand> commandArray;
	//private transient Context ctx;
	private String name = "Name not Set";
	private int iconId = R.drawable.soulisslogo;
	private int Id;


	public SoulissScene(int id) {
		super();
		//ctx = ct;
		Id = id;
		//this.commandDTO = new ArrayList<SoulissCommandDTO>();
		//this.parentTypical = parentTypical;
	}

	public int getType() {
		// typ o normal ?? rivedere politica comandi multipli
		return 666;
	}

	@Override
	public String toString() {
		return getNiceName();
	}

	public String getNiceName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return Id;
	}
	public int getDefaultIconResourceId() {
		return iconId;
	}
	public void setIconResourceId(int itemResId) {
		iconId = itemResId;
	}
	public ArrayList<SoulissCommand> getCommandArray() {
		return commandArray;
	}

	public void setCommandArray(ArrayList<SoulissCommand> commandArray) {
		this.commandArray = commandArray;
	}


    @Override
    public void execute() {
        new Thread(){public void run() {
            for (final SoulissCommand soulissCommand : commandArray) {
                Log.w(Constants.TAG,"EXECUTING SCENE Command:"+ soulissCommand.toString());
                soulissCommand.execute();
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }}.start();

    }
}