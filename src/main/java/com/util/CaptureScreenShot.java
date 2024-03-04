package com.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javax.imageio.ImageIO;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.uikeywords.UIKeywords;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class CaptureScreenShot implements ITestListener {

	String basePthScreenshot = System.getProperty("user.dir");

	Calendar cal = Calendar.getInstance();
	Date time = cal.getTime();
	String timestamp = time.toString().replace(":", "").replace(" ", "_");

	public void onTestFailure(ITestResult result) {

		AShot ashot = new AShot();
		ashot.shootingStrategy(ShootingStrategies.viewportPasting(1000));
		Screenshot sc = ashot.takeScreenshot(UIKeywords.driver);
		BufferedImage image = sc.getImage();

		try {

			ImageIO.write(image, "jpg", new File(basePthScreenshot + "/screenshots/" + "failshot_"
					+ this.getClass().getTypeName() + " _" + timestamp + "_" + ".jpg"));

		} catch (IOException e) {
			e.printStackTrace();
		}

		ITestListener.super.onTestFailure(result);
	}

}
