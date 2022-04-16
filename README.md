# LFm4J
[![Build Status](https://app.travis-ci.com/desmond27/lfm4j.svg?branch=master)](https://app.travis-ci.com/desmond27/lfm4j)

Java wrapper for LastFM's API

This project aims to provide a simple yet powerful Java based library that interfaces with the LastFM API for integrating your own applications with LastFM.

This project is still a WIP. Further usage instructions will be added in the future.

You will have to get your own LastFM API key and secret before you can use this library. Follow the instructions [here](https://www.last.fm/api/account/create) to create your own LastFM API account and obtain your own API key and API secret.

## Using this library

You must initialize the library as below before any of the services can be called.

    Lfm4J.init("yourlastfmapikey", "yourlastfmapisecret", ClientType.DESKTOP);

The API key and secret are the ones you obtain by following the link mentioned above. Currently only `ClientType.DESKTOP` has been implemented.

Once initialized, you can then call any API method as follows:

    User user = LfmUserService.getInfo("lastFmUsername");   // user.getInfo example

## What works

The following services currently work:

- user.getInfo
- user.getRecentTracks
- user.getTopArtists
- user.getTopTracks
- user.getTopAlbums

## What doesn't work

Pretty much everything else.
