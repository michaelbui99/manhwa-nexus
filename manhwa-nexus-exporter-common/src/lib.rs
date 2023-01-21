use serde::{Deserialize, Serialize};
use serde_json::Error;

#[derive(Serialize, Deserialize)]
pub struct NewsUpdate {
    timestamp: String,
    title: String,
    content: String,
    source: String,
    author: String,
}

impl NewsUpdate {
    pub fn new(timestamp: &str, title: &str, content: &str, source: &str, author: &str) -> Self {
        NewsUpdate {
            timestamp: timestamp.to_string(),
            title: title.to_string(),
            content: content.to_string(),
            source: source.to_string(),
            author: author.to_string(),
        }
    }

    pub fn from_json(json: &str) -> Result<Self, Error> {
        let update: Result<Self, Error> = serde_json::from_str(json);
        match update {
            Ok(news_update) => Ok(news_update),
            Err(err) => Err(err),
        }
    }

    pub fn to_json(news_update: &Self) -> Result<String, Error> {
        let json = serde_json::to_string(&news_update);
        match json {
            Ok(res) => Ok(res),
            Err(err) => Err(err),
        }
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn news_update_from_json_deserializes_correctly() {
        let json = r#"
        {
            "timestamp": "1674242688",
            "title": "New season of Solo Leveling drops!",
            "content": "OP once again...",
            "source": "http://some_site.com",
            "author": "Bob bobsen"
        }"#;

        let update = NewsUpdate::from_json(&json);
        match update {
            Ok(res) => {
                assert_eq!(res.author, "Bob bobsen");
                assert_eq!(res.content, "OP once again...");
                assert_eq!(res.timestamp, "1674242688");
                assert_eq!(res.title, "New season of Solo Leveling drops!");
                assert_eq!(res.source, "http://some_site.com");
            }
            Err(err) => panic!("Fail: {err}"),
        }
    }
}
