using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.IO;

using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;

namespace RecreationReservation
{
	public partial class Form1 : Form
	{
		private IWebDriver m_webDriver;
		private IWebElement m_bookNowElement;

		private string m_account;
		private string m_password;

		DateTime m_targetDateTime;

		public Form1()
		{
			InitializeComponent();

			DateTime timeNow = DateTime.Now;
			TxtHour.Text = timeNow.Hour.ToString();
			TxtMinute.Text = "0";

			m_account = File.ReadAllText(".rec-account").Trim();
			m_password = File.ReadAllText(".rec-password").Trim();
		}

		private void BtnLaunchBrowser_Click(object sender, EventArgs e)
		{
			m_webDriver = new ChromeDriver();
			m_webDriver.Navigate().GoToUrl("https://www.recreation.gov/");
			foreach (var elem in m_webDriver.FindElements(By.CssSelector("button.nav-header-button")))
			{
				if (elem.Text == "Log In")
				{
					elem.Click();
					break;
				}
			}

			Thread.Sleep(1000 * 3);


			m_webDriver.FindElement(By.Id("rec-acct-sign-in-email-address")).SendKeys(m_account);
			m_webDriver.FindElement(By.Id("rec-acct-sign-in-password")).SendKeys(m_password);
			m_webDriver.FindElement(By.CssSelector("button.rec-acct-sign-in-btn")).Click();

			Thread.Sleep(1000 * 3);

			string urlManyGlacier = "https://www.recreation.gov/camping/campgrounds/251869/availability";
			string urlDevilCreek = "https://www.recreation.gov/camping/campgrounds/234791/availability";

			m_webDriver.Navigate().GoToUrl(urlManyGlacier);
		}

		private void BtnBook_Click(object sender, EventArgs e)
		{
			m_timer.Interval = 100;

			TxtLog.Text += "\nUrl=" + m_webDriver.Url;
			TxtLog.Text += "\nClicked at " + DateTime.Now.ToString("O");
			m_bookNowElement = m_webDriver.FindElement(By.CssSelector("div.rec-campground-availability-book-now")).FindElement(By.CssSelector("button.sarsa-button-primary"));

			DateTime timeNow = DateTime.Now;
			int hour = Int32.Parse(TxtHour.Text);
			int minute = Int32.Parse(TxtMinute.Text);
			m_targetDateTime = new DateTime(timeNow.Year, timeNow.Month, timeNow.Day, hour, minute, 0);

			timeNow = DateTime.Now;
			TimeSpan diff = m_targetDateTime - timeNow;

			int milliSeconds = (int) diff.TotalMilliseconds;
			milliSeconds = milliSeconds % 100;
			milliSeconds += 50;
			Thread.Sleep(milliSeconds);

			m_timer.Start();
		}

		private void m_timer_Tick(object sender, EventArgs e)
		{
			DateTime timeNow = DateTime.Now;
			TimeSpan diff = m_targetDateTime - timeNow;

			if (Math.Abs(diff.TotalMilliseconds) < 100 || diff.TotalMilliseconds < 0)
			{
				TxtLog.Text += "\nBefore click at " + DateTime.Now.ToString("O");
				m_bookNowElement.Click();
				TxtLog.Text += "\nClicked at " + DateTime.Now.ToString("O");
				m_timer.Stop();
			}

			LblWaitSeconds.Text = diff.TotalSeconds.ToString();
		}
	}
}
