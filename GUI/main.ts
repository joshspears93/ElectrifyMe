const { app, BrowserWindow } = require('electron')
const path = require('path')
const url = require('url')

let win;

// Get environment type (dev / prod)
const args = process.argv.slice(1);
let dev = args.some(arg => arg === '--dev');

function createWindow () {
  // Create the browser window.
  win = new BrowserWindow({
    width: 600, 
    height: 600,
    backgroundColor: '#ffffff',
    icon: `file://${__dirname}/dist/assets/logo.png`
  })

  if(dev){
    win.loadURL('http://127.0.0.1:4200');
    win.webContents.openDevTools()
  }
  else{
    //win.loadURL(`file://${__dirname}/dist/my-app/index.html`)
    win.loadURL(url.format({
        //__dirname is the current working dir
        pathname: path.join(__dirname, 'dist', 'GUI' ,'index.html'),
        protocol: 'file:',
        slashes: true
        }));
  }

  // Event when the window is closed.
  win.on('closed', function () {
    win = null
  })
}

// Create window on electron intialization
app.on('ready', createWindow)

// Quit when all windows are closed.
app.on('window-all-closed', function () {

  // On macOS specific close process
  if (process.platform !== 'darwin') {
    app.quit()
  }
})

app.on('activate', function () {
  // macOS specific close process
  if (win === null) {
    createWindow()
  }
})