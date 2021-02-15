namespace RecreationReservation
{
	partial class Form1
	{
		/// <summary>
		/// Required designer variable.
		/// </summary>
		private System.ComponentModel.IContainer components = null;

		/// <summary>
		/// Clean up any resources being used.
		/// </summary>
		/// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
		protected override void Dispose(bool disposing)
		{
			if (disposing && (components != null))
			{
				components.Dispose();
			}
			base.Dispose(disposing);
		}

		#region Windows Form Designer generated code

		/// <summary>
		/// Required method for Designer support - do not modify
		/// the contents of this method with the code editor.
		/// </summary>
		private void InitializeComponent()
		{
			this.components = new System.ComponentModel.Container();
			this.BtnLaunchBrowser = new System.Windows.Forms.Button();
			this.BtnBook = new System.Windows.Forms.Button();
			this.label1 = new System.Windows.Forms.Label();
			this.LblWaitSeconds = new System.Windows.Forms.Label();
			this.m_timer = new System.Windows.Forms.Timer(this.components);
			this.TxtLog = new System.Windows.Forms.TextBox();
			this.TxtHour = new System.Windows.Forms.TextBox();
			this.label2 = new System.Windows.Forms.Label();
			this.label3 = new System.Windows.Forms.Label();
			this.TxtMinute = new System.Windows.Forms.TextBox();
			this.SuspendLayout();
			// 
			// BtnLaunchBrowser
			// 
			this.BtnLaunchBrowser.Location = new System.Drawing.Point(37, 12);
			this.BtnLaunchBrowser.Name = "BtnLaunchBrowser";
			this.BtnLaunchBrowser.Size = new System.Drawing.Size(190, 42);
			this.BtnLaunchBrowser.TabIndex = 0;
			this.BtnLaunchBrowser.Text = "Launch Browser";
			this.BtnLaunchBrowser.UseVisualStyleBackColor = true;
			this.BtnLaunchBrowser.Click += new System.EventHandler(this.BtnLaunchBrowser_Click);
			// 
			// BtnBook
			// 
			this.BtnBook.Location = new System.Drawing.Point(362, 77);
			this.BtnBook.Name = "BtnBook";
			this.BtnBook.Size = new System.Drawing.Size(144, 34);
			this.BtnBook.TabIndex = 1;
			this.BtnBook.Text = "Book";
			this.BtnBook.UseVisualStyleBackColor = true;
			this.BtnBook.Click += new System.EventHandler(this.BtnBook_Click);
			// 
			// label1
			// 
			this.label1.AutoSize = true;
			this.label1.Location = new System.Drawing.Point(358, 132);
			this.label1.Name = "label1";
			this.label1.Size = new System.Drawing.Size(41, 20);
			this.label1.TabIndex = 2;
			this.label1.Text = "Wait";
			// 
			// LblWaitSeconds
			// 
			this.LblWaitSeconds.AutoSize = true;
			this.LblWaitSeconds.Location = new System.Drawing.Point(406, 131);
			this.LblWaitSeconds.Name = "LblWaitSeconds";
			this.LblWaitSeconds.Size = new System.Drawing.Size(43, 20);
			this.LblWaitSeconds.TabIndex = 3;
			this.LblWaitSeconds.Text = "Time";
			// 
			// m_timer
			// 
			this.m_timer.Tick += new System.EventHandler(this.m_timer_Tick);
			// 
			// TxtLog
			// 
			this.TxtLog.Location = new System.Drawing.Point(37, 290);
			this.TxtLog.Multiline = true;
			this.TxtLog.Name = "TxtLog";
			this.TxtLog.Size = new System.Drawing.Size(558, 148);
			this.TxtLog.TabIndex = 4;
			// 
			// TxtHour
			// 
			this.TxtHour.Location = new System.Drawing.Point(91, 77);
			this.TxtHour.Name = "TxtHour";
			this.TxtHour.Size = new System.Drawing.Size(62, 26);
			this.TxtHour.TabIndex = 5;
			// 
			// label2
			// 
			this.label2.AutoSize = true;
			this.label2.Location = new System.Drawing.Point(37, 77);
			this.label2.Name = "label2";
			this.label2.Size = new System.Drawing.Size(48, 20);
			this.label2.TabIndex = 6;
			this.label2.Text = "Hour:";
			// 
			// label3
			// 
			this.label3.AutoSize = true;
			this.label3.Location = new System.Drawing.Point(166, 77);
			this.label3.Name = "label3";
			this.label3.Size = new System.Drawing.Size(61, 20);
			this.label3.TabIndex = 7;
			this.label3.Text = "Minute:";
			// 
			// TxtMinute
			// 
			this.TxtMinute.Location = new System.Drawing.Point(223, 76);
			this.TxtMinute.Name = "TxtMinute";
			this.TxtMinute.Size = new System.Drawing.Size(100, 26);
			this.TxtMinute.TabIndex = 8;
			// 
			// Form1
			// 
			this.AutoScaleDimensions = new System.Drawing.SizeF(9F, 20F);
			this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
			this.ClientSize = new System.Drawing.Size(800, 450);
			this.Controls.Add(this.TxtMinute);
			this.Controls.Add(this.label3);
			this.Controls.Add(this.label2);
			this.Controls.Add(this.TxtHour);
			this.Controls.Add(this.TxtLog);
			this.Controls.Add(this.LblWaitSeconds);
			this.Controls.Add(this.label1);
			this.Controls.Add(this.BtnBook);
			this.Controls.Add(this.BtnLaunchBrowser);
			this.Name = "Form1";
			this.Text = "Form1";
			this.ResumeLayout(false);
			this.PerformLayout();

		}

		#endregion

		private System.Windows.Forms.Button BtnLaunchBrowser;
		private System.Windows.Forms.Button BtnBook;
		private System.Windows.Forms.Label label1;
		private System.Windows.Forms.Label LblWaitSeconds;
		private System.Windows.Forms.Timer m_timer;
		private System.Windows.Forms.TextBox TxtLog;
		private System.Windows.Forms.TextBox TxtHour;
		private System.Windows.Forms.Label label2;
		private System.Windows.Forms.Label label3;
		private System.Windows.Forms.TextBox TxtMinute;
	}
}

