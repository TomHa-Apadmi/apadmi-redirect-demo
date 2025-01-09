# Android Browser Custom Tabs Re-direct Demo

This is a small Android application to demonstrate re-directs between custom browser tabs and an 
application.

> [WARNING!]
> This application uses [Mockzilla](https://apadmi-engineering.github.io/Mockzilla/) to locally 
> serve a dummy webpage to view in the browser. Mockzilla is a **development tool** only as it only 
> supports HTTP traffic and should not be deployed in a production environment.

## Expected behaviour

When pressing 'Open browser' and then using the web re-direct back to the app, it is expected that 
state is preserved. This can be verified by using incrementing the counter.

_Using Chrome version 131.0.6778.201_

<p align="center">
    <img src="https://raw.githubusercontent.com/TomHa-Apadmi/apadmi-redirect-demo/develop/assets/image/chrome-demo.gif" height=200>
</p>

## Behaviour on some browsers

_Using Firefox Nightly version 136.0a1_

<p align="center">
    <img src="https://raw.githubusercontent.com/TomHa-Apadmi/apadmi-redirect-demo/develop/assets/image/firefox-nightly-demo.gif" height=200>
</p>
