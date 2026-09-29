# Google Autocomplete Scraper

A simple Java application that fetches Google search autocomplete suggestions using **SerpApi** and **Google Gson**.

## Prerequisites

* A JDK (tested with Java 26)
* A SerpApi account and API key ([sign up here](https://serpapi.com))

## Dependencies

Add the SerpApi Java library and Google Gson to `build.gradle`. See the
[SerpApi Java library docs](https://github.com/serpapi/serpapi-java) for the
current dependency line.

## Set Your API Key

The app reads your key from an environment variable named `SERPAPI_KEY`.
Never hard-code the key or commit it to Git.

**Linux/macOS**
```bash
export SERPAPI_KEY="your_api_key_here"
```

**Windows (PowerShell)**
```powershell
$env:SERPAPI_KEY="your_api_key_here"
```

**Windows (Command Prompt)**
```cmd
set SERPAPI_KEY=your_api_key_here
```

## Usage

```bash
./gradlew run
```

Each run makes one SerpApi search, which counts as part of your plan's quota.

Example output:

```
Autocomplete suggestions:
* software engineers are using ai
* software engineers are using linux
```

## How It Works

`ScrapeAutocomplete` sends the query `"software engineers are using "` to
SerpApi's Google Autocomplete engine and prints each suggestion. To try a
different phrase, change the `"q"` value in `findTools()`.

## Tests

```bash
./gradlew test
```

The test calls the real API, so `SERPAPI_KEY` must be set and it uses one search.