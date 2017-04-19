package controller;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class SaveFilesController
{
	/*
	private Parent createContent()
	{
		TextField fieldName = new TextField();
		TextField fieldHP = new TextField();

		Button btSave = new Button("Save");
		btSave.setOnAction(e -> {
			SaveData data = new SaveData();
			data.name = new fieldName.getText();
			try{
				ResourceManager.save(data, "1.save");
			} catch(Exception e)
			{
				System.out.println("Couldn't save" + e.getMessage());
			}
		});
		
		Button btLoad = new Button();
		btLoad.setOnAction(e -> {
			try{
				SaveDate data = (SaveData) ResourceManger.load("1.save");
				fieldName.setText(data.name);
				fieldHP.setText(String.valueOf(data.hp));
			} catch (Exception e)
			{
				System.out.println("Couldn't load" + e.getMessage());
			}
		});
		
		
		return btSave;
	}
	*/

}
